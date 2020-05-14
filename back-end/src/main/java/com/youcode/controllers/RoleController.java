package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.exceptions.NotFoundException;
import com.youcode.models.Admin;
import com.youcode.models.Client;
import com.youcode.models.Role;
import com.youcode.services.interfaces.AdminServiceInterface;
import com.youcode.services.interfaces.ClientServiceInterface;
import com.youcode.services.interfaces.RoleServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/roles")
public class RoleController {

	@Autowired
	RoleServiceInterface role_service;
	
	@Autowired
	ClientServiceInterface client_service;
	
	@Autowired
	AdminServiceInterface admin_service;
	
	@GetMapping("")
	public ResponseEntity<List<Role>> getAll(){
		return ResponseEntity.ok(role_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Role> getOne(@PathVariable("id")int id) {
		Role role = role_service.getRole(id).orElseThrow(()->new NotFoundException("there is no role with this id"));
		return ResponseEntity.ok(role);
	}
	
	@PostMapping("")
	public ResponseEntity<Role> add(@RequestBody Role role){
		role_service.add(role);
		return ResponseEntity.ok().header("message", "role added successfully").body(role);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Role> update(@RequestBody Role role, @PathVariable("id")int role_id){
		role_service.getRole(role_id).orElseThrow(()->new NotFoundException("there is no role with this id"));
		role.setId(role_id);
		role_service.add(role);
		return ResponseEntity.ok().header("message", "role added successfully").body(role);
	}
	
	@PatchMapping("/{role_id}/client/{client_id}")
	public ResponseEntity<Client> changeClientRole(@PathVariable("role_id")int role_id, @PathVariable("client_id")int client_id){
		Client client = client_service.get(client_id).orElseThrow(()->new NotFoundException("there is no Client with this id"));
		Role role = role_service.getRole(role_id).orElseThrow(()->new NotFoundException("there is no role with this id"));
		client.setRole(role);
		client_service.add(client);
		return ResponseEntity.ok(client);
	}
	
	@PatchMapping("/{role_id}/admin/{admin_id}")
	public ResponseEntity<Admin> changeAdminRole(@PathVariable("role_id")int role_id, @PathVariable("admin_id")int admin_id){
		Admin admin = admin_service.getAdmin(admin_id).orElseThrow(()->new NotFoundException("there is no admin with this id"));
		Role role = role_service.getRole(role_id).orElseThrow(()->new NotFoundException("there is no role with this id"));
		admin.setRole(role);
		admin_service.add(admin);
		return ResponseEntity.ok(admin);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		role_service.getRole(id).orElseThrow(()->new NotFoundException("there is no role with this id"));
		role_service.delete(id);
		return ResponseEntity.ok("role deleted successfully");
	}
}
