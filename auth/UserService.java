package com.libraryapp.libraryapp.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    //UserServiceImpl getAllUsers

    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        //getAllUsers içerisinde userMail mevcut mu?
        //UserDto type'da dönülecek.
        return null;
    }
}
