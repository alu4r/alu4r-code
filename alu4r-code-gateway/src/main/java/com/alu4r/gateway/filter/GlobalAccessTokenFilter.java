package com.alu4r.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.addOriginalRequestUrl;

/**
 * @author alu4r
 */
@Slf4j
@Component
public class GlobalAccessTokenFilter implements GlobalFilter, Ordered {
    public final static String X_ACCESS_TOKEN = "X-Access-Token";

    /**
     * 在该方法中，先记录了请求的开始时间，并保存在ServerWebExchange中，此处是一个“pre”类型的过滤器，然后再chain.filter的内部类中的run()方法中相当于"post"过滤器
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        log.info("access url :  "+ url);

        // 1. 重写StripPrefix(获取真实的URL)
        addOriginalRequestUrl(exchange, exchange.getRequest().getURI());
        String rawPath = exchange.getRequest().getURI().getRawPath();
        String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(rawPath, "/")).skip(1L).collect(Collectors.joining("/"));
        ServerHttpRequest newRequest = exchange.getRequest().mutate().path(newPath).build();
        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());

        //将现在的request，添加当前身份
        ServerHttpRequest mutableReq = exchange.getRequest().mutate().header("Authorization-UserName", "").build();
        ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
        return chain.filter(mutableExchange);
    }

    /**
     * 用于定义优先级，值越大则优先级越低
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }

}
