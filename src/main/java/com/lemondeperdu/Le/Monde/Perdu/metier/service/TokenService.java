package com.lemondeperdu.Le.Monde.Perdu.metier.service;

import com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Date;

public class TokenService {

    private final JwtProperties jwtProperties;

    public TokenService(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }




    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration() ))
                .signWith(jwtProperties.getSigningKey())
                .compact();
    }

    public String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtProperties.getSigningKey())
                .build()
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        try{
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(jwtProperties.getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String username = claims.getSubject();
            boolean isTokenExprired = claims.getExpiration().before(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()));

            return username.equals(userDetails.getUsername()) && isTokenExprired;
        }
         catch (ExpiredJwtException e){
            return false;
         } catch (Exception e){
            return false;
        }
    }
}
