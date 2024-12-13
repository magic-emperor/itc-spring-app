// package com.itc.app.Security;

// import java.io.IOException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;
// import com.itc.app.Security.itcJwtUtil;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// @Component
// public class itcJwtRequestFilter extends OncePerRequestFilter{

//     @Autowired
//     private UserDetailsService userDetailsService;

//     @Autowired
//     private itcJwtUtil jwtUtil;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         final String authorizationHeader = request.getHeader("Authorization");

//         String userPhone = null;
//         String jwt = null;

//         if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//             jwt = authorizationHeader.substring(7);
//             userPhone = jwtUtil.getUsernameFromToken(jwt);
//         }

//         if (userPhone != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             UserDetails userDetails = this.userDetailsService.loadUserByUsername(userPhone);

//             if (jwtUtil.validateToken(jwt, userDetails)) {
//                 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
//                         new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                 usernamePasswordAuthenticationToken
//                         .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//             }

//         }
//         filterChain.doFilter(request, response);
//     }

// }

package com.itc.app.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class itcJwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private itcJwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            final String authorizationHeader = request.getHeader("Authorization");

            String userPhone = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);

                try {
                    userPhone = jwtUtil.extractUsername(jwt);
                } catch (ExpiredJwtException e) {
                    logger.warn("JWT Token has expired", e);
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token has expired");
                    return;
                } catch (MalformedJwtException e) {
                    logger.warn("Invalid JWT Token", e);
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
                    return;
                } catch (SignatureException e) {
                    logger.warn("JWT Signature validation failed", e);
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token signature invalid");
                    return;
                } catch (Exception e) {
                    logger.error("Error processing JWT Token", e);
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error processing token");
                    return;
                }
            }

            if (userPhone != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userPhone);

                try {
                    if (jwtUtil.validateToken(jwt, userDetails)) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken
                                .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                } catch (Exception e) {
                    logger.warn("Token validation failed", e);
                }
            }

            filterChain.doFilter(request, response);

        } catch (Exception e) {
            logger.error("Unexpected error in JWT filter", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unexpected error during authentication");
        }
    }
}