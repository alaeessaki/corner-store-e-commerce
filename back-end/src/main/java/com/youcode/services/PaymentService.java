package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.youcode.dao.PaymentDaoInterface;
import com.youcode.models.Payment;
import com.youcode.services.interfaces.PaymentServiceInterface;
@Service
public class PaymentService implements PaymentServiceInterface{

	PaymentDaoInterface payment_dao;
	
	public void add(Payment payment) {
		payment_dao.save(payment);
	}
	
	public Optional<Payment> get(int id){
		return payment_dao.findById(id);
	}
	
	public List<Payment> getAll(){
		return payment_dao.findAll();
	}
	
	public void delete(int id) {
		payment_dao.deleteById(id);
	}
}
