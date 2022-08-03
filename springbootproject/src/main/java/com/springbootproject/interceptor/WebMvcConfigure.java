package com.springbootproject.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class WebMvcConfigure implements WebMvcConfigurer {


	@Autowired
	private ApiLogger apiLogger;


	public WebMvcConfigure() {
		super();

	}
@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(apiLogger);
}
}

