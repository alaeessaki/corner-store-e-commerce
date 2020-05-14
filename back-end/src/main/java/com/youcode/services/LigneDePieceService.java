package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.LigneDePieceDaoInterface;
import com.youcode.models.LigneDePiece;
import com.youcode.services.interfaces.LigneDePieceServiceInterface;

@Service
public class LigneDePieceService implements LigneDePieceServiceInterface{
	
	@Autowired
	LigneDePieceDaoInterface ligne_dao;

	public void add(LigneDePiece ligneDePiece) {
		ligne_dao.save(ligneDePiece);
	}
	public Optional<LigneDePiece> get(int id) {
		return ligne_dao.findById(id);
	}
	public List<LigneDePiece> getAll(){
		return ligne_dao.findAll();
	}
	public void delete(int id) {
		ligne_dao.deleteById(id);
	}
}
