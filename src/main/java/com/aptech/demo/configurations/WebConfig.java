package com.aptech.demo.configurations;

import com.aptech.demo.interceptor.AdminInterceptor;
import com.aptech.demo.interceptor.ClientInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		/*
		 * registry.addInterceptor(new
		 * LoginInterceptor()).addPathPatterns("/admin/login");
		 */
    	
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/login");
        registry.addInterceptor(new ClientInterceptor()).addPathPatterns("/cart/**", "/news").excludePathPatterns("/material");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
