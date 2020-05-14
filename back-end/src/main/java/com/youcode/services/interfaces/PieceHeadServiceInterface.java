package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.PieceHead;

public interface PieceHeadServiceInterface {

	public void add(PieceHead pieceHead);
	public Optional<PieceHead> get(int id);
	public List<PieceHead> getAll();
	public void delete(int id);
	
}
