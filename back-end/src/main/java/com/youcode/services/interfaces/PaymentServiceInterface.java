package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.Payment;

public interface PaymentServiceInterface {

	public void add(Payment payment);
	public Optional<Payment> get(int id);
	public List<Payment> getAll();
	public void delete(int id);
	
}
