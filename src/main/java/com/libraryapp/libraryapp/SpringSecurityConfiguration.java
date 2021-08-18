
package com.libraryapp.libraryapp;

import com.libraryapp.libraryapp.auth.JwtTokenFilter;
import com.libraryapp.libraryapp.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    //database kullanıcı şifresi için endcoder

    public void configurePasswordEncoder(AuthenticationManagerBuilder builder){
        //pass encoder
        //authenticationManagerBuilder.UserService(userService).passwordEncoder(getBCryptPasswordEncoder());
    }

    private UserService userService;

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
                .antMatchers(HttpMethod.GET).hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.cors().disable();
            http.csrf().disable();

        //jwtTokenFilter
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }
}