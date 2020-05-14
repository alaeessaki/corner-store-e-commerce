package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.LigneDePiece;

public interface LigneDePieceServiceInterface {

	public void add(LigneDePiece ligneDePiece);
	public Optional<LigneDePiece> get(int id);
	public List<LigneDePiece> getAll();
	public void delete(int id);
	
}
