package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.mapper.Utilizator;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;
import java.util.Iterator;

import static org.springframework.security.config.Customizer.withDefaults;

//asta e o clasa de test, poate fi scoasa ulterior
@RestController
class LoginController {

    @GetMapping("/")
    public String home() {
        return "esti acasa bine ai venit";
    }

    @GetMapping("/test")
    public String getUser(Authentication userDetails) {
        return "User Details: " + ((DefaultOidcUser) userDetails.getPrincipal()).getEmail();
    }

}


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    UtilizatorService utilizatorService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    // astea sunt vizibile si fara sa fii logged in
                    auth.requestMatchers("/", "/error", "/oauth2/**", "/login/**").permitAll();
                    auth.requestMatchers("/favicon.ico").permitAll();
                    //toate celelalte nu sunt
                    auth.anyRequest().authenticated();
                })
                .oauth2Login( x -> {
                        x.successHandler((request, response, authentication) -> {
                            DefaultOidcUser user = ((DefaultOidcUser) authentication.getPrincipal());
                            String email = user.getEmail();

                            if(utilizatorService.getUtilizatorByEmail(email) == null){
                                Utilizator util = new Utilizator();
                                util.setEmailUtilizator(email);
                                util.setNumeUtilizator(user.getFamilyName());
                                util.setPrenumeUtilizator(user.getGivenName());
                                util.setUsernameUtilizator((user.getGivenName() + "_" + user.getFamilyName()).toLowerCase().replace('-', '_').replace(' ', '_'));
                                utilizatorService.saveUtilizator(util);
                            }

                            response.sendRedirect("/");

                        });

                }

                )
                .logout(withDefaults())
                .build();
    }

}