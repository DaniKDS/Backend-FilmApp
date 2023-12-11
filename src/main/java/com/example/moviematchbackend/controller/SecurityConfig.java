package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;
import java.util.Iterator;

import static org.springframework.security.config.Customizer.withDefaults;

//asta e o clasa de test, poate fi scoasa ulterior
@CrossOrigin(origins = "http://localhost:5173")
@RestController
class LoginController {

    // mock function, folosita pentru autentificare
    @GetMapping("/api/test")
    public String getUser(Authentication userDetails) {
        return "";
    }

    @GetMapping("/api/print_session")
    public String print_session(@RequestHeader("Cookie") String session) {
        return session;
    }
}

@CrossOrigin(origins = "http://localhost:5173")
@Configuration
@EnableWebSecurity
public class  SecurityConfig {

    @Autowired
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
            .oauth2Login(x -> {
                    x.successHandler((request, response, authentication) -> {
                        DefaultOidcUser user = ((DefaultOidcUser) authentication.getPrincipal());
                        String email = user.getEmail();
                        if (utilizatorService.getUtilizatorByEmail(email) == null) {
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
                .csrf(
                        x -> {
                            x.disable();
                        }
                )
                .logout(
                        x -> {
                            x.logoutSuccessUrl("/");
                            x.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                        }
                )
                .build();
    }

}

