package com.mysite.sbb.jwt;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class JwtTokenFilterConfigurer {
	
	private JwtTokenProvider jwtTokenProvider;
	
	public JwtTokenFilterConfigurer(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Bean
	public FilterRegistrationBean<JwtTokenFilter> filterBean() {
		FilterRegistrationBean<JwtTokenFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtTokenFilter(jwtTokenProvider));
		registrationBean.addUrlPatterns("/*"); // 필터를 설정할 url
		registrationBean.setName("jwtTokenFitler");
		return registrationBean;
	}
}
