package com.itc.app.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // Allow all endpoints
				.allowedOrigins("http://localhost:3000", "https://itc-app.onrender.com") // Frontend origin
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
				.allowedHeaders("*") // Allow all headers
				.allowCredentials(true); // Allow credentials (important for auth)
	}
}