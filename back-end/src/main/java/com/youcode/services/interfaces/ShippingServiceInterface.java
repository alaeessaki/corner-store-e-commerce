package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.Shipping;

public interface ShippingServiceInterface {

	public void add(Shipping shipping);
	public Optional<Shipping> get(int id);
	public Shipping findFirstByOrderByNameAsc();
	public List<Shipping> getAll();
	public void delete(int id);
	
}
