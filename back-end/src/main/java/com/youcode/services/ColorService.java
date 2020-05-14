package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.ColorDaoInterface;
import com.youcode.models.Color;
import com.youcode.services.interfaces.ColorServiceInterface;

@Service
public class ColorService implements ColorServiceInterface{
	
	@Autowired
	ColorDaoInterface color_dao;
	
	public void add(Color color) {
		color_dao.save(color);
	}
	
	public Optional<Color> get(int id){
		return color_dao.findById(id);
	}
	
	public List<Color> getAll(){
		return color_dao.findAll();
	}
	
	public void delete(int id) {
		color_dao.deleteById(id);
	}
	
	
}
