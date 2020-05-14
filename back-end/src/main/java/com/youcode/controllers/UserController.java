package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.dto.User;
import com.youcode.services.interfaces.UserServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UserController {

	
	@Autowired
	UserServiceInterface user_service;

	@GetMapping("")
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok(user_service.getAll());
	}
}
