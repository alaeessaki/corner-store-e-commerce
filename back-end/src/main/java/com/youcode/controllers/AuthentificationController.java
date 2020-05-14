package com.youcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.security.AuthentificationRequest;
import com.youcode.security.AuthentificationResponse;
import com.youcode.security.JwtUtil;
import com.youcode.services.CostumUserDetailsService;



@RestController
@CrossOrigin
public class AuthentificationController {
	
	@Autowired
	JwtUtil jwtokenUtil;
	
	@Autowired
	CostumUserDetailsService customUserDetailsService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	

	@RequestMapping(value="/authenticate" ,method =RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody AuthentificationRequest authentificationRequest) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), authentificationRequest.getPassword()));
				
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("incorrect username ou password",e);
		}
		
		final UserDetails userdetails=customUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
		final String jwt=jwtokenUtil.generateToken(userdetails);
		
		return ResponseEntity.ok().body(new AuthentificationResponse(jwt));
	}
}
