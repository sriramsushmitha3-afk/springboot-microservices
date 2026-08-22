package com.ecommerce.user.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecommerce.user.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
 
@Service
public class JwtService {
 
	 @Value("${jwt.secret}")
	 private String secretKey;
 
	  @Value("${jwt.expiration}")
	  private long jwtExpiration;

	  public String generateToken(User user) {

	   return Jwts.builder()
			   .claim("userId", user.getUserId())
			   .claim("email", user.getEmail())
			   .claim("role", user.getRole().name())
			   .subject(user.getEmail())
			   .issuedAt(new Date())
			   .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
			   .signWith(getSigningKey())
			   .compact();

	}
 
	private Key getSigningKey() {

		byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
	    return Keys.hmacShaKeyFor(keyBytes);

	}

}
 
