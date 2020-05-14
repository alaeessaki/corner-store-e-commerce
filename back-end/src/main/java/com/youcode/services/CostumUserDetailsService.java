package com.youcode.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.youcode.dto.User;
import com.youcode.exceptions.NotFoundException;
import com.youcode.models.Role;
import com.youcode.services.interfaces.UserServiceInterface;


@Service
public class CostumUserDetailsService implements UserDetailsService{

	@Autowired
	UserServiceInterface userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.findByUsername(username).orElseThrow(()->new NotFoundException("there is no user with this username"));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));
//		return new org.springframework.security.core.userdetails.User("alae","alae12",new ArrayList());
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		Role role = user.getRole();
		authorities.add(new SimpleGrantedAuthority(role.getLabel()));
		
		return authorities;
	}
}
