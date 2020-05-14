package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.Piece;

public interface PieceServiceInterface {

	public void add(Piece piece);
	public Optional<Piece> get(int id);
	public List<Piece> getAll();
	public void delete(int id);
	
}
