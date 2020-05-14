package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.RoleDaoInterface;
import com.youcode.models.Role;
import com.youcode.services.interfaces.RoleServiceInterface;

@Service
public class RoleService implements RoleServiceInterface{

	@Autowired
	RoleDaoInterface role_dao;
	
	public void add(Role role) {
		role_dao.save(role);
	}
	
	public Optional<Role> getRole(int id) {
		return role_dao.findById(id);
	}
	
	public List<Role> getAll(){
		return role_dao.findAll();
	}
	
	public void delete(int id){
		role_dao.deleteById(id);
	}
}
