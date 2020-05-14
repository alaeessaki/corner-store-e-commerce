package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.PieceHeadDaoInterface;
import com.youcode.models.PieceHead;
import com.youcode.services.interfaces.PieceHeadServiceInterface;

@Service
public class PieceHeadService implements PieceHeadServiceInterface{

	@Autowired
	PieceHeadDaoInterface piece_head_dao;
	
	public void add(PieceHead pieceHead) {
		piece_head_dao.save(pieceHead);
	}
	
	public Optional<PieceHead> get(int id){
		return piece_head_dao.findById(id);
	}
	
	public List<PieceHead> getAll(){
		return piece_head_dao.findAll();
	}
	
	public void delete(int id) {
		piece_head_dao.deleteById(id);
	}
}
