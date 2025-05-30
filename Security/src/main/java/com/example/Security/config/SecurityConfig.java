package com.example.Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/dashboard").hasAnyRole("ADMIN", "SALE")
                        .requestMatchers("/users/**").hasRole("ADMIN")
                        .requestMatchers("/categories/**").hasAnyRole("ADMIN", "SALE")
                        .requestMatchers("/products/**").hasAnyRole("ADMIN", "SALE")
                        .requestMatchers("/brands/**").hasAnyRole("ADMIN", "SALE")
                        .requestMatchers("/orders/**").hasAnyRole("ADMIN", "SALE")
                        .requestMatchers("/posts/**").hasAnyRole("ADMIN", "SALE", "AUTHOR")
                        .requestMatchers("/profile/**").hasRole("USER")
                        .requestMatchers("/", "/login", "/resources/**", "/css/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .successHandler((request, response, authentication) -> {
                            var authorities = authentication.getAuthorities();
                            String redirectUrl = "/dashboard"; // mặc định

                            if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
                                redirectUrl = "/profile";
                            } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_AUTHOR"))) {
                                redirectUrl = "/posts";
                            }

                            response.sendRedirect(redirectUrl);
                        })
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails sale = User.builder()
                .username("sale")
                .password(passwordEncoder().encode("sale123"))
                .roles("SALE")
                .build();

        UserDetails author = User.builder()
                .username("author")
                .password(passwordEncoder().encode("author123"))
                .roles("AUTHOR")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, sale, author, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
