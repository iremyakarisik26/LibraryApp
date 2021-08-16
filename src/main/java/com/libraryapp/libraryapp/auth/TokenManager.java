package com.libraryapp.libraryapp.auth;

import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class TokenManager {

    /**
     * HS256 olacak şekilde bir key oluşturulmalı
     private Key key  =??

     *Token expired için 5 dakika
     private final int expirationTime = 5*60*1000;
     */

    public String generateToken(String userMail){
    //key ve expirationTime parametreleri token oluşturulurken kullanılacak.
        return null;
    }

    public boolean validateToken(String token){
      //isExpired
     return  false;
    }

    public String getUserMailToken(String token){

        return null;
    }

    //Claim işlemi/methodu olcak.

}
