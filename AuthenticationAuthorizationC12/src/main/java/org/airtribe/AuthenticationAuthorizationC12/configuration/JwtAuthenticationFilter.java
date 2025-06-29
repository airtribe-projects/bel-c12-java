package org.airtribe.AuthenticationAuthorizationC12.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.airtribe.AuthenticationAuthorizationC12.util.JwtUtility;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


public class JwtAuthenticationFilter extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String authenticationHeader = request.getHeader("authorization");

    if (authenticationHeader == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().write("Missing Authorization header");
      return;
    }

    if(!JwtUtility.validateToken(authenticationHeader)) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().write("Invalid user token");
      return;
    }

    Claims claims = JwtUtility.getClaims(authenticationHeader);

    String username = claims.getSubject();
    String role = claims.get("roles", String.class);
    List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));
    UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(username, null, authorities);

    SecurityContextHolder.getContext().setAuthentication(authentication);

    filterChain.doFilter(request, response);

  }

  protected boolean shouldNotFilter(HttpServletRequest request) {
    String path = request.getRequestURI();
    return path.contains("register") || path.contains("signin") || path.contains("verifyRegistration");
  }
}
