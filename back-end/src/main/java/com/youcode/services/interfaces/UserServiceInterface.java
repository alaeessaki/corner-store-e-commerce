package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.dto.User;

public interface UserServiceInterface {

	public List<User> getAll();
	
	public Optional<User> findByUsername(String username);
}
