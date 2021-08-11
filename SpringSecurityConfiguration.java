
package com.libraryapp.libraryapp;

import com.libraryapp.libraryapp.auth.JwtTokenFilter;
import com.libraryapp.libraryapp.auth.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.libraryapp.libraryapp.auth.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    //database kullanıcı şifresi için endcoder

    public void configurePasswordEncoder(AuthenticationManagerBuilder builder){
        //pass encoder
        authenticationManagerBuilder.UserService(userService).passwordEncoder(getBCryptPasswordEncoder());
    }

    private UserDetailsService userService;

    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity http) throws Exception {
        //metotlar için role izinleri olacak
        //Örneğin get api'leri için User post,put,delete,get Admin
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/book").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/magazine").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/newspaper").hasRole("USER")
                .antMatchers("/deposits", "/admin").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/book").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/magazine").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/newspaper").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/user").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/book", "/magazine", "/newspaper", "/user").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/user", "/book", "/magazine", "/newspaper").hasRole("ADMIN")

        //jwtTokenFilter
        //http.addFilterBefore(jwtTokenFilter,);
    }
}
}