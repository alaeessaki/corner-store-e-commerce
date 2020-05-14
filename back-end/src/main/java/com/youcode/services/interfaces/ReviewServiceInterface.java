package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.Review;

public interface ReviewServiceInterface {

	public void add(Review review);
	public Optional<Review> get(int id);
	public List<Review> getAll();
	public void delete(int id);
	
}
