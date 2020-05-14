package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.ClientDaoInterface;
import com.youcode.models.Client;
import com.youcode.services.interfaces.ClientServiceInterface;

@Service
public class ClientService implements ClientServiceInterface{

	@Autowired
	ClientDaoInterface client_dao;
	
	public void add(Client client) {
		client_dao.save(client);
	}
	
	public Optional<Client> get(int id){
		return client_dao.findById(id);
	}
	
	public List<Client> getAll(){
		return client_dao.findAll();
	}
	
	public void delete(int id) {
		client_dao.deleteById(id);
	}
}
