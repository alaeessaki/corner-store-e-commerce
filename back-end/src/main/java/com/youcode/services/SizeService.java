package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.SizeDaoInterface;
import com.youcode.models.Size;
import com.youcode.services.interfaces.SizeServiceInterface;

@Service
public class SizeService implements SizeServiceInterface{

	@Autowired
	SizeDaoInterface size_dao;
	
	public void add(Size size) {
		size_dao.save(size);
	}
	public Optional<Size> get(int id){
		return size_dao.findById(id);
	}
	public List<Size> getAll(){
		return size_dao.findAll();
	}
	
	public void delete(int id) {
		size_dao.deleteById(id);
	}
}
