package com.libraryapp.libraryapp.auth;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        String userMail = null;
        String token = null;
   /**
    * authHeader için null check eklenecek içindeki token alınacak. ve parametre olan token'a setlenecek
    * alınan token içerisinde de mail adresi alınıp userMail setlenecek.
        if(){

        }
     */

   /**
    * userMail için null check işlemi yapılcak
    * token için null check işlemi yapılcak
        if(){


         }
    */

        filterChain.doFilter(request, response);

    }
}
