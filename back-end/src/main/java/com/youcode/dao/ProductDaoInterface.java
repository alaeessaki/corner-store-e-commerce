package com.youcode.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.youcode.models.Category;
import com.youcode.models.Product;

public interface ProductDaoInterface extends PagingAndSortingRepository<Product, Integer>{
	List<Product> findAllByCategory(Pageable pageable, Category category);
	List<Product> findTop8ByOrderBySellsDesc();
}
