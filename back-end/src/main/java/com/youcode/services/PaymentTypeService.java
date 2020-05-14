package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.PaymentTypeDaoInterface;
import com.youcode.models.PaymentType;
import com.youcode.services.interfaces.PaymentTypeServiceInterface;

@Service
public class PaymentTypeService implements PaymentTypeServiceInterface{

	@Autowired
	PaymentTypeDaoInterface payment_type_dao;
	
	
	public void add(PaymentType payment_type) {
		payment_type_dao.save(payment_type);
	}
	
	public Optional<PaymentType> get(int id){
		return payment_type_dao.findById(id);
	}
	
	public List<PaymentType> getAll(){
		return payment_type_dao.findAll();
	}
	
	public void delete(int id) {
		payment_type_dao.deleteById(id);
	}
}
