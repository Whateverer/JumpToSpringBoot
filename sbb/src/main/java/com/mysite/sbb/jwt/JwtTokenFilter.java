package com.mysite.sbb.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;
/**
 * HTTP Request에서 토큰을 읽어 들여 정상 토큰 요청 진행하게 하는 클래스
 * @author user
 *
 */
//We should use OncePerRequestFilter since we are doing a database call, there is no point in doing this more than once
// request 이전에 1회 작동할 필터
@Slf4j
@Component
@WebFilter()
public class JwtTokenFilter extends OncePerRequestFilter{

	private JwtTokenProvider jwtTokenProvider;
	
	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = jwtTokenProvider.resolveToken(request);
		try {
//			if(token != null && jwtTokenProvider.validateToken(token)) {
//				AppUserRole auth = jwtTokenProvider.getAuthentication(token);
				log.info("filtering 됨");
//			}
//		} catch (CustomException ex) {
		} catch (Exception ex) {
			//this is very important, since it guarantees the user is not authenticated at all
			SecurityContextHolder.clearContext();
//			response.sendError(ex.getHttpStatus().value(), ex.getMessage());
		}
		
		filterChain.doFilter(request, response); // 다음 필터체인 실행
	}

}
