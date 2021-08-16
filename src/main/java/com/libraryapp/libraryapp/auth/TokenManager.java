package com.libraryapp.libraryapp.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class TokenManager {

    /**
     * HS256 olacak şekilde bir key oluşturulmalı
     * private Key key  =??
     * <p>
     * Token expired için 5 dakika
     * private final int expirationTime = 5*60*1000;
     */
    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 1000;

    @Value("${jwt.secret}")
    private String secret;

    public String getUsermailFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails) {

        Map<String, Object> claims = new HashMap<>();
        return GenerateToken(claims, userDetails.getUsermail());
    }

    private Boolean isTokenExpired(String token) {
        final Claims claims = getClaims(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }

    public boolean validateToken(String token) {
        return Objects.nonNull(getClaims(token).getSubject()) && !isTokenExpired(token);

    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}