package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.exceptions.NotFoundException;
import com.youcode.models.LigneDePiece;
import com.youcode.models.Piece;
import com.youcode.models.PieceHead;
import com.youcode.services.interfaces.PieceServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/pieces")
public class PieceController {

	@Autowired
	PieceServiceInterface piece_service;

	@GetMapping("")
	public ResponseEntity<List<Piece>> getAll(){
		return ResponseEntity.ok(piece_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Piece> getPiece(@PathVariable("id")int id){
		Piece piece = piece_service.get(id).orElseThrow(()->new NotFoundException("there is no piece with this id"));
		return ResponseEntity.ok(piece);
	}
	
	@GetMapping("/{id}/lignes-de-piece")
	public ResponseEntity<List<LigneDePiece>> getPiceLigneDePiece(@PathVariable("id")int id){
		Piece piece = piece_service.get(id).orElseThrow(()->new NotFoundException("there is no piece with this id"));
		return ResponseEntity.ok(piece.getLigne_de_pieces());
	}
	
	@GetMapping("/{id}/piece-heads")
	public ResponseEntity<List<PieceHead>> getPieceHeads(@PathVariable("id")int id){
		Piece piece = piece_service.get(id).orElseThrow(()->new NotFoundException("there is no piece with this id"));
		return ResponseEntity.ok(piece.getPiece_heads());
	}
	
	@PostMapping("")
	public ResponseEntity<Piece> addPiece(@RequestBody Piece piece){
		piece.checkAttributes();
		piece_service.add(piece);
		return ResponseEntity.ok(piece);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Piece> updatePece(@RequestBody Piece piece, @PathVariable("id")int id){
		piece_service.get(id).orElseThrow(()->new NotFoundException("there is no piece with this id"));
		piece.setId(id);
		piece_service.add(piece);
		return ResponseEntity.ok(piece);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePiece(@PathVariable("id")int id){
		piece_service.get(id).orElseThrow(()->new NotFoundException("there is no piece with this id"));
		piece_service.delete(id);
		return ResponseEntity.ok("piece deleted successfully");
	}
}
