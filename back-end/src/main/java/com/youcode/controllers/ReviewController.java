package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.exceptions.NotFoundException;
import com.youcode.models.Client;
import com.youcode.models.Product;
import com.youcode.models.Review;
import com.youcode.services.interfaces.ClientServiceInterface;
import com.youcode.services.interfaces.ProductServiceInterface;
import com.youcode.services.interfaces.ReviewServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	ReviewServiceInterface review_service;
	
	@Autowired
	ProductServiceInterface product_service;
	
	@Autowired
	ClientServiceInterface client_service;
	
	@GetMapping("")
	public ResponseEntity<List<Review>> getAll(){
		return ResponseEntity.ok(review_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Review> getReview(@PathVariable("id")int id){
		Review review = review_service.get(id).orElseThrow(()->new NotFoundException("there is no review with this id"));
		return ResponseEntity.ok(review);
	}
	
	@PostMapping("/product/{product_id}/client/{client_id}")
	public ResponseEntity<Review> addReview(@RequestBody Review review, @PathVariable("product_id")int product_id, @PathVariable("client_id")int client_id){
		Product product = product_service.get(product_id).orElseThrow(()->new NotFoundException("there is no product with this id"));
		review.setProduct(product);
		Client client = client_service.get(client_id).orElseThrow(()->new NotFoundException("there is no client with this id"));
		review.setClient(client);
		review_service.add(review);
		product.getStars_collection().incStars(review.getStars());
		product_service.add(product);
		return ResponseEntity.ok(review);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Review> replaceReview(@PathVariable("id")int id, @RequestBody Review review){
		review_service.get(id).orElseThrow(()->new NotFoundException("there is no review with this id"));
		review.setId(id);
		review_service.add(review);
		return ResponseEntity.ok(review);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable("id")int id,@RequestBody Review updated_review){
		Review review = review_service.get(id).orElseThrow(()->new NotFoundException("there is no review with this id"));
		review.setContent(updated_review.getContent());
		review.setImage(updated_review.getImage());
		review.setStars(updated_review.getStars());
		review_service.add(review);
		return ResponseEntity.ok(review);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable("id")int id){
		review_service.get(id).orElseThrow(()->new NotFoundException("there is no review with this id"));
		review_service.delete(id);
		return ResponseEntity.ok("review deleted successfully");
	}
}
