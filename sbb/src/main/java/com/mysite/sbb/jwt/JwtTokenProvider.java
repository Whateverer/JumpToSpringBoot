package com.mysite.sbb.jwt;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/**
 * 토큰 제공을 위한 class
 * @author user
 *
 */
@Component
@Slf4j
public class JwtTokenProvider {
	/**
	 * THIS IS NOT A SECURE PRACTICE! For simplicity, we are storing a static key here. Ideally, in a
	 * microservices environment, this key would be kept on a config-server.
	 */
	// 실제 사용시에는 config-server에 key가 저장되어야 한다.
//	@Value("${jwt.token.secret-key:secret-key}") // application.yml에 저장
	private final String secretKey = "secretKey";
	
//	@Value("${jwt.token.expire-length:3600000}")
	private final long validityInMilliseconds = 3600000; // 1h
	
//	@Value("${jwt.token.expire-length:3600000}")
	private final long refeshTokenValidityInMilliseconds = 60000 * 60 * 24 * 7; // 7 days
	
	@PostConstruct
	protected void init() {
		
	}
	
	/**
	 * Access 토큰 생성하여 반환
	 * @param username
	 * @param appUserRoles
	 * @return
	 */
//	public String createToken(String username, AppUserRole appUserRole) {
//		Claims claims = Jwts.claims().setSubject(username);
//		claims.put("auth", appUserRole);
//		
//		Date now = new Date();
//		Date validity = new Date(now.getTime() + validityInMilliseconds);
//		
//		return Jwts.builder()
//				.setClaims(claims)
//				.setIssuedAt(now)
//				.setExpiration(validity)
//				.signWith(SignatureAlgorithm.HS256, secretKey) // TODO : secretKey 만들기
//				.compact();
//	}
//	
//	/**
//	 * Refresh 토큰 생성하여 반환
//	 * @return
//	 */
//	public String createRefreshToken() {
//		Date now = new Date();
//		Date validity = new Date(now.getTime() + refeshTokenValidityInMilliseconds);
//		return Jwts.builder()
//				.setIssuedAt(now)
//				.setExpiration(validity)
//				.signWith(SignatureAlgorithm.HS256, secretKey)
//				.compact();
//	}
//	
//	/**
//	 * 토큰으로부터 클레임을 만들고, 이를 통해 user 객체를 생성하여 Authentication 객체를 반환
//	 * @param token
//	 * @return Authentication
//	 */
//	public AppUserRole getAuthentication(String token) {
//		// TODO : token에서 authentication을 가져와서 넘기기
//		Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//		AppUserRole appUserRole = (AppUserRole)claims.getBody().get("auth");
//		return appUserRole;
//	}
//	
//	/**
//	 * 토큰을 받아 username을 가져온다.
//	 * @param token
//	 * @return username
//	 */
//	public String getUsername(String token) {
//		return Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody().getSubject();
//	}
//	
	/**
	 * http 헤더로부터 bearer 토큰을 가져온다.
	 * @param request
	 * @return bearerToken
	 */
	public String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}
//	
//	/**
//	 * 토큰을 검증한다.
//	 * @param token
//	 * @return 유효한 토큰인지 여부
//	 */
//	public boolean validateToken(String token) {
//		try {
//			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//			return true;
//		} catch (JwtException | IllegalArgumentException e) {
//			throw new CustomException("Expired or invalid JWT token", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
