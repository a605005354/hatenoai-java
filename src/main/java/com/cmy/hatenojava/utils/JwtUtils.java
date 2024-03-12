package com.cmy.hatenojava.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import java.util.Date;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.utils
 * @className: JwtUtils
 * @author: Terry Cai
 * @description: Utils for JWT Token authentication
 * @date: 3/6/24 2:44 PM
 * @version: 1.0
 */

public class JwtUtils {
    private static final String SECRET_KEY = "HatenoAIno1"; // Use a strong, unique key
    private static final long EXPIRATION_TIME = 900_000; // 15 minutes in milliseconds

    public static String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_KEY));
    }

    public static String validateTokenAndRetrieveSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Failed to verify JWT", exception);
        }
    }
}
