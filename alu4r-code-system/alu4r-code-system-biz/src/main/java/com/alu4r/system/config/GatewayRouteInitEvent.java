package com.alu4r.system.config;

import org.springframework.context.ApplicationEvent;

/**
 * 路由初始化事件
 */
public class GatewayRouteInitEvent extends ApplicationEvent {

    public GatewayRouteInitEvent(Object source) {
        super(source);
    }
}

