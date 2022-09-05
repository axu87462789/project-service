package com.guapixu.commons.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * @author lizx
 * @since 2022-09-05
 */
public class JwtUtils {
    private static String sign = "guaPiXu";

    public static String createToken(){
        return JWT.create().sign(Algorithm.HMAC256(sign));
    }
}
