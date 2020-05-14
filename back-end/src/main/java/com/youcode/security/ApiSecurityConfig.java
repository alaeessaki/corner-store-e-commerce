package com.youcode.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailService;

	@Autowired
	private RequestFilter jwtrequestfilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailService);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().disable()
		.authorizeRequests().antMatchers("/authenticate").permitAll().antMatchers("/v2/api-docs","/configuration/ui","/swagger-resources/**","/configuration/security","/swagger-ui.html","/webjars/**").permitAll().
		antMatchers("/api/categories/**").permitAll().antMatchers("/downloadFile/**").permitAll().and().authorizeRequests().antMatchers("/api/admins/**").hasAuthority("admin")
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(jwtrequestfilter, UsernamePasswordAuthenticationFilter.class);
		
		
	}
	
	
}
