package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.Client;

public interface ClientServiceInterface {

	public void add(Client client);
	public Optional<Client> get(int id);
	public List<Client> getAll();
	public void delete(int id);
	
}
