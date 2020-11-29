package com.alu4r.gateway.filter;

import com.alu4r.gateway.utils.JwtUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

/**
 * 过滤器
 * @Author EiletXie
 * @Since 2020/3/12 16:23
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("****** come in MyLogGateWayFilter: " + new Date());
//
//        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
//        if(uname == null) {
//          log.info("*****用户名为null，非法用户，o(╥﹏╥)o");
//          exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//          return exchange.getResponse().setComplete();
//        }
        List<String> authorization = exchange.getRequest().getHeaders().get("Authorization");
        String token = authorization.get(0);
        if(token == null){
            throw new Exception("请携带token");
        }
        if(!JwtUtils.parseToken(token)){
            throw new Exception("token失效");
        }
        return chain.filter(exchange);
    }

    /**
     * 加载过滤器的顺序，数字越小，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
