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
import com.youcode.models.Color;
import com.youcode.services.interfaces.ColorServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api")
public class ColorController {

	@Autowired
	ColorServiceInterface color_service;

	
	@GetMapping("/colors")
	public ResponseEntity<List<Color>> getAll(){
		return ResponseEntity.ok(color_service.getAll());
	}
	
	@GetMapping("/colors/{id}")
	public ResponseEntity<Color> getOne(@PathVariable("id")int id) {
		Color color = color_service.get(id).orElseThrow(()->new NotFoundException("there is no Color with this id"));
		return ResponseEntity.ok(color);
	}
	
	@PostMapping("/admins/colors")
	public ResponseEntity<Color> add(@RequestBody Color color){
		color_service.add(color);
		return ResponseEntity.ok().header("message", "Color added successfully").body(color);
	}
	
	@PutMapping("/admins/colors/{id}")
	public ResponseEntity<Color> update(@RequestBody Color color, @PathVariable("id")int color_id){
		color_service.get(color_id).orElseThrow(()->new NotFoundException("there is no Color with this id"));
		color.setId(color_id);
		color_service.add(color);
		return ResponseEntity.ok().header("message", "Color added successfully").body(color);
	}
	
	@DeleteMapping("/admins/colors/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		color_service.get(id).orElseThrow(()->new NotFoundException("there is no Color with this id"));
		color_service.delete(id);
		return ResponseEntity.ok("Color deleted successfully");
	}
}
