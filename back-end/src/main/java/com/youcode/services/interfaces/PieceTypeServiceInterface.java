package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.PieceType;

public interface PieceTypeServiceInterface {

	public void add(PieceType pieceType);
	public Optional<PieceType> get(int id);
	public List<PieceType> getAll();
	public void delete(int id);
	
}
