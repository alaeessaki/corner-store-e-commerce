package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.exceptions.NotFoundException;
import com.youcode.models.Size;
import com.youcode.services.interfaces.SizeServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/sizes")
public class SizeController {

	@Autowired
	SizeServiceInterface size_service;
	
	@GetMapping("")
	public ResponseEntity<List<Size>> getAll(){
		return ResponseEntity.ok(size_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Size> getOne(@PathVariable("id")int id) {
		Size size = size_service.get(id).orElseThrow(()->new NotFoundException("there is no Size with this id"));
		return ResponseEntity.ok(size);
	}
	
	@PostMapping("")
	public ResponseEntity<Size> add(@RequestBody Size size){
		size_service.add(size);
		return ResponseEntity.ok().header("message", "Size added successfully").body(size);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Size> update(@RequestBody Size size, @PathVariable("id")int size_id){
		size_service.get(size_id).orElseThrow(()->new NotFoundException("there is no Size with this id"));
		size.setId(size_id);
		size_service.add(size);
		return ResponseEntity.ok().header("message", "Size added successfully").body(size);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		size_service.get(id).orElseThrow(()->new NotFoundException("there is no Size with this id"));
		size_service.delete(id);
		return ResponseEntity.ok("Size deleted successfully");
	}
}
