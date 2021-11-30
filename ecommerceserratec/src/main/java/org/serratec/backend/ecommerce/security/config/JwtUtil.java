package org.serratec.backend.ecommerce.security.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${auth.jwt-secret}")
	private String jwtSecret;

	@Value("${auth.jwt-miliseg}")
	private long jwtExpirationMiliseg;

	public String generateToken(String nome) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + jwtExpirationMiliseg); 
		
		return Jwts.builder()
				.setSubject(nome)
				.setExpiration(validity)
				.signWith(SignatureAlgorithm.HS512, this.jwtSecret.getBytes())
				.compact();
	}
	
	public boolean isValidToken(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}
	
	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}
	
	private Claims getClaims(String token) {
		try {
			return Jwts.parser()
					.setSigningKey(jwtSecret.getBytes())
					.parseClaimsJws(token)
					.getBody();
		} catch (Exception e) {
			return null;
		}
	}

}
