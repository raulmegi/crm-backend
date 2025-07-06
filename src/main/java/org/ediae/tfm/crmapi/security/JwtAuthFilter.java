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

        if (path.startsWith("/appUser/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        if (path.startsWith("/appUser/registro")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = extractJwtFromCookies(request);
        if (token != null && jwtService.validateToken(token)) {
            String email = jwtService.extractUsername(token);
            try {
                AppUser appUser = appUserService.findAppUserByEmail(email);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(appUser, null, List.of());
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (GeneralException e) {
                System.out.println("[JwtAuthFilter] Failed to find user by email: " + e.getMessage());
            }
        }
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

