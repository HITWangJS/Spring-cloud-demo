package com.edu.test.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {

//    private static final long EXPIRE_TIME = 60 * 60 * 1000;
//
//    public static boolean verify(String token, String username, String secret) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
//            verifier.verify(token);
//            return true;
//        } catch (Exception exception) {
//            return false;
//        }
//    }
//
//    public static String sign(String username, String secret) {
//        try {
//            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            // 附带username信息
//            return JWT.create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
//        } catch (UnsupportedEncodingException e) {
//            return null;
//        }
//    }

    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String getRole(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("systemRole").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

}
