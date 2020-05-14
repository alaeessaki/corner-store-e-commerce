package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.AdminDaoInterface;
import com.youcode.models.Admin;
import com.youcode.services.interfaces.AdminServiceInterface;

@Service
public class AdminService implements AdminServiceInterface{
	
	@Autowired
	AdminDaoInterface admin_dao;
	
	public void add(Admin admin) {
		admin_dao.save(admin);
	}
	
	public Optional<Admin> getAdmin(int id){
		return admin_dao.findById(id);
	}
	
	public List<Admin> getAll(){
		return admin_dao.findAll();
	}
	
	public void delete(int id) {
		admin_dao.deleteById(id);
	}
}
