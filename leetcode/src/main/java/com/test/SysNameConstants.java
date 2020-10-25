package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 系统名称
 * @author: alu4r
 * @date: 2020/10/15 16:04
 */
public class SysNameConstants {
    public final static Map<String, String> SYS_NAME_KEY = new HashMap<>();
    static {
        SYS_NAME_KEY.put("service-auth","Portal平台/认证服务");
        SYS_NAME_KEY.put("service-center","Portal平台/微服务注册中心");
        SYS_NAME_KEY.put("service-config","Portal平台/微服务配置中心");
        SYS_NAME_KEY.put("service-expert","Portal平台/专家库");
        SYS_NAME_KEY.put("service-file","Portal平台/文件系统");
        SYS_NAME_KEY.put("service-gateway","Portal平台/网关");
        SYS_NAME_KEY.put("service-log","Portal平台/日志记录");
        SYS_NAME_KEY.put("service-message","Portal平台/短信服务");
        SYS_NAME_KEY.put("service-permission","Portal平台/权限服务");
        SYS_NAME_KEY.put("service-release","Portal平台/CMS");
        SYS_NAME_KEY.put("service-user","Portal平台/用户管理");
        SYS_NAME_KEY.put("service-dv","Portal平台/查数服务");
    }
}
