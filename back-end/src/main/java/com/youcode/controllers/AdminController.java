package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.youcode.exceptions.NotFoundException;
import com.youcode.models.Admin;
import com.youcode.services.interfaces.AdminServiceInterface;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/admins")
public class AdminController {

	@Autowired
	AdminServiceInterface admin_service;
	
	@GetMapping("")
	public List<Admin> getAll(){
		return admin_service.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("id")int id){
		Admin admin = admin_service.getAdmin(id).orElseThrow(()->new NotFoundException("there is no admin with this id"));
		return ResponseEntity.ok(admin);
	}
	
	@PostMapping("")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		admin_service.add(admin);
		return ResponseEntity.ok().header("message", "admin added successfully").body(admin);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id")int id, @RequestBody Admin admin){
		admin_service.getAdmin(id).orElseThrow(()->new NotFoundException("there is no admin with this id"));
		admin.setId(id);
		admin_service.add(admin);
		return ResponseEntity.ok(admin);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("id")int id){
		admin_service.getAdmin(id).orElseThrow(()->new NotFoundException("there is no admin with this id"));
		admin_service.delete(id);
		return ResponseEntity.ok("admin deleted successfully");
	}
}
