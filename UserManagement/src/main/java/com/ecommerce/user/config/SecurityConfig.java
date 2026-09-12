package com.ecommerce.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ecommerce.user.security.JwtAuthFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final JwtAuthFilter jwtAuthFilter;
	
	@Bean
	//throws Exception -- httpSecurity.build() can throw an exception depending on the Spring Security version/configuration.
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
	
		httpSecurity.csrf(csrf->csrf.disable())
					.authorizeHttpRequests(auth-> auth.
													requestMatchers("/auth/login").permitAll()
													.requestMatchers("/users/**").hasRole("ADMIN")
													.anyRequest().authenticated()
													).addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
		
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	

}
