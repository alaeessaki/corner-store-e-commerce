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
import com.youcode.models.Shipping;
import com.youcode.services.interfaces.ShippingServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/shippings")
public class ShippingController {

	@Autowired
	ShippingServiceInterface shipping_service;
	
	@GetMapping("")
	public ResponseEntity<List<Shipping>> getAll(){
		return ResponseEntity.ok(shipping_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Shipping> getOne(@PathVariable("id")int id) {
		Shipping shipping = shipping_service.get(id).orElseThrow(()->new NotFoundException("there is no Shipping with this id"));
		return ResponseEntity.ok(shipping);
	}
	
	@PostMapping("")
	public ResponseEntity<Shipping> add(@RequestBody Shipping shipping){
		shipping_service.add(shipping);
		return ResponseEntity.ok().header("message", "Shipping added successfully").body(shipping);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Shipping> update(@RequestBody Shipping shipping, @PathVariable("id")int shipping_id){
		shipping_service.get(shipping_id).orElseThrow(()->new NotFoundException("there is no Shipping with this id"));
		shipping.setId(shipping_id);
		shipping_service.add(shipping);
		return ResponseEntity.ok().header("message", "Shipping added successfully").body(shipping);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		shipping_service.get(id).orElseThrow(()->new NotFoundException("there is no Shipping with this id"));
		shipping_service.delete(id);
		return ResponseEntity.ok("Shipping deleted successfully");
	}
}
