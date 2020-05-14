package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.exceptions.NotFoundException;
import com.youcode.models.Image;
import com.youcode.services.interfaces.ImageServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/images")
public class ImageController {

	@Autowired
	ImageServiceInterface image_service;
	
	@GetMapping("")
	public ResponseEntity<List<Image>> getAll(){
		return ResponseEntity.ok(image_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Image> getImage(@PathVariable("id")int id){
		Image image = image_service.getImage(id).orElseThrow(()->new NotFoundException("there is no image with this id"));
		return ResponseEntity.ok(image);
	}
}
