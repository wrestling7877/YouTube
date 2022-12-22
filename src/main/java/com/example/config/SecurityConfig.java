package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailService customUserDetailsService;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        // authentication  -> login,password to'grimi,   user activemi?


        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // authorization  murojat qilayotgan userni dostupi bormi?

        http.csrf().disable().authorizeHttpRequests()
                //.requestMatchers("/user/**").hasAnyRole("USER","ADMIN") //you must log in and become a user OR an admin
                .requestMatchers("/profile/admin/*").hasRole("ADMIN") //you must log in and become a user
                .requestMatchers("/region/**").hasRole("ADMIN")//you must log in and become an admin
                .requestMatchers("/article_type/admin/**").hasRole("ADMIN")//you must log in and become an admin
                .requestMatchers("/category/**").hasRole("ADMIN")//you must log in and become an admin
                .requestMatchers("/attach/admin/*").hasRole("ADMIN")//you must log in and become an admin
                .requestMatchers("/article/public/**").hasAnyRole("USER", "ADMIN", "MODERATOR", "PUBLISHER")//you must log in and become an admin
                .requestMatchers("/emailHistoryController/admin/*").hasRole("ADMIN")//you must log in and become an admin
                .requestMatchers("/auth/**").permitAll() /// you don't have to do log In and  this way is open for everyone
                .requestMatchers("/init/user").permitAll() /// you don't have to do log In and  this way is open for everyone
                .anyRequest().authenticated()
                .and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

        // .and().formLogin();
        // .and().httpBasic();

        return http.build();
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
