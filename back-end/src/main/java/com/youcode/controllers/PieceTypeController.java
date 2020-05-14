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
import com.youcode.models.PieceType;
import com.youcode.services.interfaces.PieceTypeServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/piece-types")
public class PieceTypeController {

	@Autowired
	PieceTypeServiceInterface piece_type_service;

	@GetMapping("")
	public ResponseEntity<List<PieceType>> getAll(){
		return ResponseEntity.ok(piece_type_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PieceType> getOne(@PathVariable("id")int id) {
		PieceType pieceType = piece_type_service.get(id).orElseThrow(()->new NotFoundException("there is no Piece Type with this id"));
		return ResponseEntity.ok(pieceType);
	}
	
	@PostMapping("")
	public ResponseEntity<PieceType> add(@RequestBody PieceType pieceType){
		piece_type_service.add(pieceType);
		return ResponseEntity.ok().header("message", "Piece Type added successfully").body(pieceType);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PieceType> update(@RequestBody PieceType pieceType, @PathVariable("id")int pieceType_id){
		piece_type_service.get(pieceType_id).orElseThrow(()->new NotFoundException("there is no Piece Type with this id"));
		pieceType.setId(pieceType_id);
		piece_type_service.add(pieceType);
		return ResponseEntity.ok().header("message", "Piece Type added successfully").body(pieceType);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		piece_type_service.get(id).orElseThrow(()->new NotFoundException("there is no Piece Type with this id"));
		piece_type_service.delete(id);
		return ResponseEntity.ok("Piece Type deleted successfully");
	}
}
