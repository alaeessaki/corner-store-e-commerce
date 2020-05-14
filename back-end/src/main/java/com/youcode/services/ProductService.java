package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.youcode.dao.ProductDaoInterface;
import com.youcode.models.Category;
import com.youcode.models.Product;
import com.youcode.services.interfaces.ProductServiceInterface;

@Service
public class ProductService implements ProductServiceInterface{

	@Autowired
	ProductDaoInterface product_dao;
	
	public void add(Product product) {
		product_dao.save(product);
	}
	
	public Optional<Product> get(int id){
		return product_dao.findById(id);
	}
	public List<Product> findAllByCategory(Pageable pageable, Category category){
		return product_dao.findAllByCategory(pageable, category);
	}
	
	@Override
	public List<Product> getAllByCategory(PageRequest pageRequest, Category productCategory) {
		return product_dao.findAllByCategory(pageRequest, productCategory);
	}
	public List<Product> findTop8ByOrderBySellsDesc(){
		return product_dao.findTop8ByOrderBySellsDesc();
	}
	public List<Product> getAll(PageRequest pageRequest){
		return product_dao.findAll(pageRequest).getContent();
	}
	
	public void delete(int id) {
		product_dao.deleteById(id);
	}
}
