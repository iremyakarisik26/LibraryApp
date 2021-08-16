package com.libraryapp.libraryapp.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.libraryapp.libraryapp.dto.UserDto;
import com.libraryapp.libraryapp.repos.UserRepository;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    //UserServiceImpl getAllUsers

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        //getAllUsers içerisinde userMail mevcut mu?
        //UserDto type'da dönülecek.

        final Optional<User> oUser; // = ???
        if (oUser.isPresent()) {
            return UserDto of (oUser); //???
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("User with e-mail {0} does not exist", userMail));
        }
        return null;
    }
}
