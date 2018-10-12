package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	public BCryptPasswordEncoder passwordEncoder() {
		
		BCryptPasswordEncoder password = new BCryptPasswordEncoder();
		
		return password;
		
	}

}
