package com.alu4r.auth.utils;


import com.alu4r.auth.entity.UserInfo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @description: JWT
 * @author: alu4r
 * @date: 2020/11/29 15:34
 */
public class JwtUtils {

    /**
     * 密钥
     */
    public static final String sign = "sign";
    /**
     * 获取token
     */
    public static String getToken(UserInfo userInfo){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 60 * 60 * 12);
        String token = JWT.create().withHeader(new HashMap<>())
                .withClaim("userId", userInfo.getId())
                .withClaim("userName", userInfo.getUserName())
                //设置过期时间为20秒后
                .withExpiresAt(instance.getTime())
                //加密密钥
                .sign(Algorithm.HMAC256(sign));
        return token;
    }

    /**
     * 解析token
     */
    public static boolean parseToken(String token){
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(sign)).build();
            jwtVerifier.verify(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
