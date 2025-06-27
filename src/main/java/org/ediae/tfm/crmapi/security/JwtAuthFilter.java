package org.ediae.tfm.crmapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ediae.tfm.crmapi.entity.AppUser;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.service.iAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private iAppUserService appUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println("[JwtAuthFilter] Request path: " + path);

        if (path.startsWith("/appUser/login")) {
            System.out.println("[JwtAuthFilter] Skipping filter for /appUser/login");
            filterChain.doFilter(request, response);
            return;
        }

        if (path.startsWith("/appUser/registro")) {
            System.out.println("[JwtAuthFilter] Skipping filter for /appUser/registro");
            filterChain.doFilter(request, response);
            return;
        }

        // 1. Extract token from cookies
        String token = extractJwtFromCookies(request);
        System.out.println("[JwtAuthFilter] Token received: " + token);

        // 2. Validate token
        if (token != null && jwtService.validateToken(token)) {
            System.out.println("[JwtAuthFilter] Token is valid.");
            String email = jwtService.extractUsername(token);
            System.out.println("[JwtAuthFilter] Extracted email from token: " + email);

            try {
                AppUser appUser = appUserService.findAppUserByEmail(email);
                System.out.println("[JwtAuthFilter] Authenticated user: " + appUser.getEmail());

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(appUser, null, List.of());
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (GeneralException e) {
                System.out.println("[JwtAuthFilter] Failed to find user by email: " + e.getMessage());
            }
        } else {
            System.out.println("[JwtAuthFilter] Token validation failed or token missing.");
        }

        // Continue
        filterChain.doFilter(request, response);
    }


    private String extractJwtFromCookies(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("jwt".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}

