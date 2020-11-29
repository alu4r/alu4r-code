package com.alu4r.gateway.utils;


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
