package com.kanbanico.api.security;

import com.kanbanico.api.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        String token = getJWTFromRequest(request);

        if (StringUtils.hasText(token)) {
            String userEmail = jwtService.extractUserName(token);
            if (userEmail != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
                if (jwtService.isTokenValid(token, userDetails)) {
                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken
                                (
                                        userDetails,
                                        null,
                                        userDetails.getAuthorities()
                                );
                        authentication.setDetails(new WebAuthenticationDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }

                }
            }

        }
        
        filterChain.doFilter(request, response);
    }

    private String getJWTFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}

