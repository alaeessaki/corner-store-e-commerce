package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.PieceTypeDaoInterface;
import com.youcode.models.PieceType;
import com.youcode.services.interfaces.PieceTypeServiceInterface;

@Service
public class PieceTypeService implements PieceTypeServiceInterface{

	@Autowired
	PieceTypeDaoInterface piece_type_dao;
	
	public void add(PieceType pieceType) {
		piece_type_dao.save(pieceType);
	}
	
	public Optional<PieceType> get(int id){
		return piece_type_dao.findById(id);
	}
	
	public List<PieceType> getAll(){
		return piece_type_dao.findAll();
	}
	
	public void delete(int id) {
		piece_type_dao.deleteById(id);
	}
}
