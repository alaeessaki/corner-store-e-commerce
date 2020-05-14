package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;

import com.youcode.models.Category;
import com.youcode.models.Product;

public interface ProductServiceInterface {

	public void add(Product product);
	public Optional<Product> get(int id);
	public List<Product> getAll(PageRequest pageRequest);
	public List<Product> getAllByCategory(PageRequest pageRequest,Category productCategory);
	public List<Product> findTop8ByOrderBySellsDesc();
	public void delete(int id);
	
}
