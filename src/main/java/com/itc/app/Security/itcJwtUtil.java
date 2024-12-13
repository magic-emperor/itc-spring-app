// package com.itc.app.Security;

// import java.util.Base64;
// import java.util.Date;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// @Component
// public class itcJwtUtil {

//     private String secretKey;

//     @Value("${secret.key}")
//     public void setSecretKey(String secretKey) {
//         // this.secretKey = new String(secretKey);
//         this.secretKey = secretKey;
//         System.out.println("Secret Key Injected: " + this.secretKey);
//     }

//     public String generateToken(String userPhone, long userId, String userRole) {
//         return Jwts.builder()
//                 .setSubject(userPhone)
//                 .claim("userId", userId)
//                 .claim("role", userRole)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token valid for 10 hours
//                 .signWith(SignatureAlgorithm.HS256, secretKey)
//                 .compact();
//     }

//     public boolean validateToken(String token, UserDetails userDetails) {
//         final String userPhone = getUsernameFromToken(token);
//         return (userPhone.equals(userDetails.getUsername()) && !isTokenExpired(token));
//     }

//     public String getUsernameFromToken(String token) {
//         Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//         return claims.getSubject();
//     }

//     public boolean isTokenExpired(String token) {
//         Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//         return claims.getExpiration().before(new Date());
//     }

//     // public boolean validateToken(String jwt, String username) {
//     // // TODO Auto-generated method stub
//     // return false;
//     // }

//     public Long getUserIdFromToken(String token) {
//         Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//         return claims.get("userId", Long.class);
//     }
// }

package com.itc.app.Security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class itcJwtUtil {

    @Value("${secret.key}")
    private String secretKeyString;

    private Key getSigningKey() {
        byte[] keyBytes = secretKeyString.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String userPhone, long userId, String userRole) {
        return Jwts.builder()
                .setSubject(userPhone)
                .claim("userId", userId)
                .claim("role", userRole)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token valid for 10 hours
                .signWith(getSigningKey())
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userPhone = extractUsername(token);
        return (userPhone.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public Long getUserIdFromToken(String token) {
        return extractClaim(token, claims -> claims.get("userId", Long.class));
    }

    public String getUserRoleFromToken(String token) {
        return extractClaim(token, claims -> claims.get("role", String.class));
    }
}