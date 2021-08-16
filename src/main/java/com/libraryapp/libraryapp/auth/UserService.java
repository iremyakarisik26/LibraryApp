package com.libraryapp.libraryapp.auth;

import com.libraryapp.libraryapp.services.IUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.libraryapp.libraryapp.dto.UserDto;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        //1. getAllUsers içerisinde userMail mevcut mu? _> userMail için Contains

        boolean hasUser = userService.getAllUsers().stream()
                .map(UserDto::getUserMail)
                .anyMatch(item -> item.contains(userMail));

        if (hasUser) {

        }


        //2. service açılıp repodan bu userMail bilgisiyle bir kayıt mevcut mu
        /**
         *  UserDto user= userService.getOneUser(userMail);
         *         if(Objects.nonNull(user)){
         *
         *         }
          */

        //UserDto type'da dönülecek.
        return null;
    }
}
