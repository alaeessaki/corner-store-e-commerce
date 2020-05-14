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
import com.youcode.models.Payment;
import com.youcode.services.interfaces.PaymentServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/payments")
public class PaymentController {
	
	@Autowired
	PaymentServiceInterface payment_service;

	@GetMapping("")
	public ResponseEntity<List<Payment>> getAll(){
		return ResponseEntity.ok(payment_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable("id")int id){
		Payment payment = payment_service.get(id).orElseThrow(()->new NotFoundException("there is no payment with this id"));
		return ResponseEntity.ok(payment);
	}
	
	@PostMapping("")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment){
		payment_service.add(payment);
		return ResponseEntity.ok(payment);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable("id")int id, @RequestBody Payment payment){
		payment_service.get(id).orElseThrow(()->new NotFoundException("there is no payment with this id"));
		payment.setId(id);
		payment_service.add(payment);
		return ResponseEntity.ok(payment);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePayment(@PathVariable("id")int id){
		payment_service.get(id).orElseThrow(()->new NotFoundException("there is no payment with this id"));
		payment_service.delete(id);
		return ResponseEntity.ok("payment deleted successfully");
	}
}
