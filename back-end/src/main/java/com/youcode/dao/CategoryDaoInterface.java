package com.youcode.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.models.Category;

@Repository
public interface CategoryDaoInterface extends JpaRepository<Category, Integer>{
	public List<Category> findByParentIsNull();
	public Optional<Category> findByLabel(String category_name);

}
