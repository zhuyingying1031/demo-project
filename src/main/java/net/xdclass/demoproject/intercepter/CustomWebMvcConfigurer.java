package net.xdclass.demoproject.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
 class CustomWebMvcConfigurer implements WebMvcConfigurer {
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {

	 	registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/api/v1/pri/**");
	 	WebMvcConfigurer.super.addInterceptors(registry);
	 }
	 @Bean
	public  LoginIntercepter getLoginIntercepter(){
	 	return  new LoginIntercepter();
	 }
 }
