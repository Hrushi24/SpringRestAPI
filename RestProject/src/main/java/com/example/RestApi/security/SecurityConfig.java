package com.example.RestApi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(authorize->authorize
//						.anyRequest().permitAll())
						.requestMatchers(HttpMethod.GET, "/users/**")
				        .permitAll()
				        .requestMatchers(HttpMethod.POST, "/users")
				        .permitAll()
				        .requestMatchers(HttpMethod.PUT, "/users/**")
				        .permitAll()
						.requestMatchers(HttpMethod.GET, "/users/{id}/blogs")
				        .permitAll()
				        

				.anyRequest().authenticated())
				.httpBasic(withDefaults())
				.build();
	}
}
