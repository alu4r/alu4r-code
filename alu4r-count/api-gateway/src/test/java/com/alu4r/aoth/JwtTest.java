package com.alu4r.aoth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/11/29 15:07
 */

public class JwtTest {
    String token = "";
    String sign = "sign"; //密钥
    /**
     * 获取token
     */
    public void getToken(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 20);
        token = JWT.create().withHeader(new HashMap<>())
                .withClaim("userId", "0")
                .withClaim("userName", "alu4r")
                .withExpiresAt(instance.getTime()) //设置过期时间为20秒后
                .sign(Algorithm.HMAC256(sign));//加密密钥
        System.out.println("过期时间：" + instance.getTime());
        System.out.println(token);
    }

    /**
     * 解析token
     */
    public void parseToken(){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(sign)).build();
        DecodedJWT verify = jwtVerifier.verify(token);
        System.out.println(verify.getClaim("userId").asString());
        System.out.println(verify.getClaim("userName").asString());
    }
    @Test
    public void jwtTest(){
        getToken();
        parseToken();
    }

}
