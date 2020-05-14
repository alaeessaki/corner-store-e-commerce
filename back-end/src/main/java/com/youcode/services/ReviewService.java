package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.ReviewDaoInterface;
import com.youcode.models.Review;
import com.youcode.services.interfaces.ReviewServiceInterface;

@Service
public class ReviewService implements ReviewServiceInterface{

	@Autowired
	ReviewDaoInterface review_dao;

	public void add(Review review) {
		review_dao.save(review);
	}
	
	public Optional<Review> get(int id){
		return review_dao.findById(id);
	}
	
	public List<Review> getAll(){
		return review_dao.findAll();
	}
	
	public void delete(int id) {
		review_dao.deleteById(id);
	}
}

