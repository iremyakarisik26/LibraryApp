package com.libraryapp.libraryapp.auth;

import com.libraryapp.libraryapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.libraryapp.libraryapp.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        //1. getAllUsers içerisinde userMail mevcut mu? _> userMail için Contains
        UserDetails userDetail = null;
        UserDto user = userService.getAllUsers().stream()
                .filter(Objects::nonNull)
                .filter(s -> s.getUserMail().equalsIgnoreCase(userMail))
                .findAny()
                .orElse(null);


        if (Objects.nonNull(user)) {
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().toUpperCase()));
            userDetail = new User(user.getUserMail(),user.getUserPassword(),grantedAuthorityList);
        }
        //2. service açılıp repodan bu userMail bilgisiyle bir kayıt mevcut mu
        /**
         *  UserDto user= userService.getOneUser(userMail);
         *         if(Objects.nonNull(user)){
         *
         *         }
          */

        //UserDto type'da dönülecek.
        return userDetail;
    }
}
