package com.libraryapp.libraryapp.controllers;

import com.libraryapp.libraryapp.auth.TokenManager;
import com.libraryapp.libraryapp.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody UserDto user) {
        // try - catch veya throw

        /** authenticationManager ile authenticate yapılcak
         * yapılırken user içerisindeki mail ve pass ile yapılcak.
         * authenticate yapıldıktan sonra tokenManager içerisindeki generateToken kullanılarak token üretilecek.
         */

        return ResponseEntity.ok("başarılı");
    }
}
