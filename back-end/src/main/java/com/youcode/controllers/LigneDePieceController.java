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

import com.youcode.exceptions.NotFoundException;
import com.youcode.models.LigneDePiece;
import com.youcode.services.interfaces.LigneDePieceServiceInterface;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/lignes-de-piece")
public class LigneDePieceController {
	
	@Autowired
	LigneDePieceServiceInterface ligne_de_piece_service;
	
	
	@GetMapping("")
	public ResponseEntity<List<LigneDePiece>> getAll(){
		return ResponseEntity.ok(ligne_de_piece_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LigneDePiece> getLigneDePiece(@PathVariable("id")int id){
		LigneDePiece ligneDePiece = ligne_de_piece_service.get(id).orElseThrow(()->new NotFoundException("there is no ligne de piece with this id"));
		return ResponseEntity.ok(ligneDePiece);
	}
	
	@PostMapping("")
	public ResponseEntity<LigneDePiece> addLigneDePiece(@RequestBody LigneDePiece ligneDePiece){
		ligneDePiece.checkAttributes();
		ligne_de_piece_service.add(ligneDePiece);
		return ResponseEntity.ok(ligneDePiece);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LigneDePiece> addLigneDePiece(@RequestBody LigneDePiece ligneDePiece, @PathVariable("id")int id){
		ligneDePiece.checkAttributes();
		ligneDePiece.setId(id);
		ligne_de_piece_service.add(ligneDePiece);
		return ResponseEntity.ok(ligneDePiece);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLigneDePiece(@PathVariable("id")int id){
		ligne_de_piece_service.get(id).orElseThrow(()->new NotFoundException("there is no ligne de piece with this id"));
		ligne_de_piece_service.delete(id);
		return ResponseEntity.ok("ligne de piece deleted successfully");
	}
}
