package org.airtribe.AuthenticationAuthorizationC12.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.util.Date;


public class JwtUtility {
  private static Key secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

  public static String generateToken(String username, String role) {
    return Jwts.builder()
        .subject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 8 * 60 * 60 * 1000))
        .claim("roles", "ROLE_" + role)
        .signWith(secretKey)
        .compact();
  }

  public static boolean validateToken(String authenticationHeader) {
    try {
      Claims body = Jwts.parser().setSigningKey(secretKey).build().parseSignedClaims(authenticationHeader).getPayload();
    } catch (SignatureException exception) {
      System.err.println("Invalid JWT signature: " + exception.getMessage());
      return false;
    } catch (io.jsonwebtoken.ExpiredJwtException exception) {
      System.err.println("JWT token is expired: " + exception.getMessage());
      return false;
    } catch (io.jsonwebtoken.MalformedJwtException exception) {
      System.err.println("Invalid JWT token: " + exception.getMessage());
      return false;
    } catch (io.jsonwebtoken.UnsupportedJwtException exception) {
      System.err.println("JWT token is unsupported: " + exception.getMessage());
      return false;
    } catch (IllegalArgumentException exception) {
      System.err.println("JWT claims string is empty: " + exception.getMessage());
      return false;
    }
    return true;
  }

  public static Claims getClaims(String authenticationHeader) {
    try {
      return Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(authenticationHeader).getBody();
    } catch (Exception e) {
      System.err.println("Error parsing JWT claims: " + e.getMessage());
      return null;
    }
  }
}
