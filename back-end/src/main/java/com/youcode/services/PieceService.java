package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.PieceDaoInterface;
import com.youcode.models.Piece;
import com.youcode.services.interfaces.PieceServiceInterface;

@Service
public class PieceService implements PieceServiceInterface{

	@Autowired
	PieceDaoInterface piece_dao;

	public void add(Piece piece) {
		piece_dao.save(piece);
	}
	
	public Optional<Piece> get(int id){
		return piece_dao.findById(id);
	}
	
	public List<Piece> getAll(){
		return piece_dao.findAll();
	}
	
	public void delete(int id) {
		piece_dao.deleteById(id);
	}
}
