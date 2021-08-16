package com.libraryapp.libraryapp.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.*;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.KeyStore;
import java.sql.Connection;
import java.sql.Statement;
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

    public static final int validity = 5 * 60 * 1000;

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String getUsermailFromToken(String token) {
        Claims claims=getClaims(token);
        return claims.getSubject();
    }


    public String generateToken(String userMail) {

      return  Jwts.builder()
              .setSubject(userMail)
              .setIssuer("libraryapp.com") // hangi uygulama için oluştuğu?
              .setIssuedAt(new Date(System.currentTimeMillis())) // ne zaman bilgisi
              .setExpiration(new Date(System.currentTimeMillis()+validity)) //oluştuğu zaman ve expired date'i (now+5dk)
              .signWith(key) // key buraya verilecek
              .compact();
    }

    private Boolean isTokenExpired(String token) {
        final Claims claims = getClaims(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }

    public boolean validateToken(String token) {
        return Objects.nonNull(getClaims(token).getSubject()) && !isTokenExpired(token);

    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

}