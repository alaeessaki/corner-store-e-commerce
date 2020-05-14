package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.UserDaoInterface;
import com.youcode.dto.User;
import com.youcode.services.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	UserDaoInterface user_dao;
	
	public List<User> getAll(){
		return user_dao.findAll();
	}
	
	public Optional<User> findByUsername(String username){
		return user_dao.findByUsername(username);
	}
}
