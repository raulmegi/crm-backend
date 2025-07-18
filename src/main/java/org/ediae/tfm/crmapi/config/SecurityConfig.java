package org.ediae.tfm.crmapi.config;

import org.ediae.tfm.crmapi.security.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
  }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
             .cors(cors -> {})
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/appUser/login",
                                "/appUser/registro",
                                "/appUser/logout",
                               "/v3/api-docs/**",
                               "/swagger-ui/**",
                               "/swagger-ui.html",
                                "/crm_db.html",
                                "/"

                        ).permitAll()
                        .anyRequest().authenticated()
                )
               .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
               .build();
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .cors(cors -> {}) // Enables CORS using your WebMvcConfigurer
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll() // Allow all requests
//                )
//                // TEMPORARILY DISABLED: JWT filter
//                // .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .build(); // ✅ Don't forget to build the chain
//    }

}



