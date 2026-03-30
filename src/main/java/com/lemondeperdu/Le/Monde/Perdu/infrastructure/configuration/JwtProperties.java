package com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration;

import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.security.Key;
import java.util.Base64;
@Configuration
@ConfigurationProperties(prefix= "spring.security.jwt")
public class JwtProperties {

    private String secret;
    private long expiration;

    public Key getSigningKey(){
        byte[] decoded = Base64.getDecoder().decode(secret);
        return Keys.hmacShaKeyFor(decoded);
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }
}
