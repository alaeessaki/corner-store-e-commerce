package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.Admin;

public interface AdminServiceInterface {

	public void add(Admin admin);
	public Optional<Admin> getAdmin(int id);
	public List<Admin> getAll();
	public void delete(int id);
	
}
