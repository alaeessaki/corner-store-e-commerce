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
import com.youcode.models.PaymentType;
import com.youcode.services.interfaces.PaymentTypeServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/payment-types")
public class PaymentTypeController {

	@Autowired
	PaymentTypeServiceInterface payment_type_service;
	
	@GetMapping("")
	public ResponseEntity<List<PaymentType>> getAll(){
		return ResponseEntity.ok(payment_type_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentType> getOne(@PathVariable("id")int id) {
		PaymentType paymentType = payment_type_service.get(id).orElseThrow(()->new NotFoundException("there is no PaymentType with this id"));
		return ResponseEntity.ok(paymentType);
	}
	
	@PostMapping("")
	public ResponseEntity<PaymentType> add(@RequestBody PaymentType paymentType){
		payment_type_service.add(paymentType);
		return ResponseEntity.ok().header("message", "PaymentType added successfully").body(paymentType);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PaymentType> update(@RequestBody PaymentType paymentType, @PathVariable("id")int paymentType_id){
		payment_type_service.get(paymentType_id).orElseThrow(()->new NotFoundException("there is no PaymentType with this id"));
		paymentType.setId(paymentType_id);
		payment_type_service.add(paymentType);
		return ResponseEntity.ok().header("message", "PaymentType added successfully").body(paymentType);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		payment_type_service.get(id).orElseThrow(()->new NotFoundException("there is no PaymentType with this id"));
		payment_type_service.delete(id);
		return ResponseEntity.ok("PaymentType deleted successfully");
	}
}
