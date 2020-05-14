package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.CategoryDaoInterface;
import com.youcode.models.Category;
import com.youcode.services.interfaces.CategoryServiceInterface;

@Service
public class CategoryService implements CategoryServiceInterface{

	@Autowired
	CategoryDaoInterface category_dao;

	public void add(Category category) {
		category_dao.save(category);
	}
	
	public Optional<Category> getByName(String category_name){
		return category_dao.findByLabel(category_name);
	}
	
	public Optional<Category> get(int id){
		return category_dao.findById(id);
	}
	
	public List<Category> getAllParents(){
		return category_dao.findByParentIsNull();
	}
	
	public List<Category> getAll(){
		return category_dao.findAll();
	}
	
	public void delete(int id) {
		category_dao.deleteById(id);
	}
}
