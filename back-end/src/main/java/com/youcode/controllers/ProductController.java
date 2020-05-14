package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.exceptions.NotFoundException;
import com.youcode.models.Category;
import com.youcode.models.Product;
import com.youcode.models.Review;
import com.youcode.services.interfaces.CategoryServiceInterface;
import com.youcode.services.interfaces.ProductServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/products")
public class ProductController {

	
	@Autowired
	ProductServiceInterface product_service;
	
	@Autowired
	CategoryServiceInterface category_service; 
	
	private boolean isBlank(String param) {
		return param.isEmpty() || param.trim().equals("");
	}

	private Sort getSort(String sort) {
		switch (sort) {
		case "lowest":
			return Sort.by(Sort.Direction.ASC, "price");
		case "highest":
			return Sort.by(Sort.Direction.DESC, "price");
		case "name":
			return Sort.by(Sort.Direction.ASC, "name");
		default:
			return null;
		}
	}
	
	@GetMapping("")
	public ResponseEntity<List<Product>> getAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "category", required = false) String category){
		
		if (page == null || size == null) {
			throw new IllegalArgumentException("Page and size parameters are required");
		}
		
		PageRequest pageRequest;
		if (sort != null && !isBlank(sort)) {
			Sort sortRequest = getSort(sort);
			if (sortRequest == null) {
				throw new IllegalArgumentException("Invalid sort parameter");
			}
			pageRequest = PageRequest.of(page, size, sortRequest);
		} else {
			pageRequest = PageRequest.of(page, size);
		}
		if (category != null && !isBlank(category)) {
			Category productCategory = category_service.getByName(category).orElseThrow(()->new NotFoundException("there is no category with this name"));
			return ResponseEntity.ok(product_service.getAllByCategory(pageRequest, productCategory));
		}
		return ResponseEntity.ok(product_service.getAll(pageRequest));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id")int id){
		Product product = product_service.get(id).orElseThrow(()->new NotFoundException("there is no product with this id"));
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/{id}/reviews")
	public ResponseEntity<List<Review>> getProductReviews(@PathVariable("id")int id){
		Product product = product_service.get(id).orElseThrow(()->new NotFoundException("there is no product with this id"));
		return ResponseEntity.ok(product.getReviews());
	}

	@PostMapping("")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		product.checkAttributes();		
		product_service.add(product);		
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id")int id){
		product_service.get(id).orElseThrow(()->new NotFoundException("there is no product with this id"));
		product.setId(id);
		product.checkAttributes();
		product_service.add(product);
		return ResponseEntity.ok(product);
	}
	
//	@PatchMapping("/{id}/rating")
//	public ResponseEntity<String> incRating(@PathVariable("id") int id, @RequestBody float rating){
//		Product product = product_service.get(id).orElseThrow(()->new NotFoundException("there is no product with this id"));
//		product.setRating(rating);
//		product_service.add(product);
//		return ResponseEntity.ok("rating updated successfully");
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id")int id){
		product_service.get(id).orElseThrow(()->new NotFoundException("there is no product with this id"));
		product_service.delete(id);
		return ResponseEntity.ok("product deleted successfully");
	}
	
}
