package com.youcode.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.exceptions.NotFoundException;
import com.youcode.models.PieceHead;
import com.youcode.models.Shipping;
import com.youcode.services.interfaces.PieceHeadServiceInterface;
import com.youcode.services.interfaces.ShippingServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/piece-heads")
public class PieceHeadController {

	@Autowired
	PieceHeadServiceInterface piece_head_service;
	
	@Autowired
	ShippingServiceInterface shipping_service;
	
	@GetMapping("")
	public ResponseEntity<List<PieceHead>> getAll(){
		return ResponseEntity.ok(piece_head_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PieceHead> getPieceHead(@PathVariable("id")int id){
		PieceHead pieceHead = piece_head_service.get(id).orElseThrow(()->new NotFoundException("there is no piece head with this id"));
		return ResponseEntity.ok(pieceHead);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addPieceHead(@RequestBody PieceHead pieceHead){
		Shipping shipping = shipping_service.findFirstByOrderByNameAsc();
		if(shipping==null) return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("something went wrong while setting the shipping");
		pieceHead.setShipping(shipping);
		pieceHead.checkAttributes();
		piece_head_service.add(pieceHead);
		return ResponseEntity.ok(pieceHead);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PieceHead> updatePieceHead(@RequestBody PieceHead pieceHead, @PathVariable("id")int id){
		pieceHead.checkAttributes();
		piece_head_service.add(pieceHead);
		return ResponseEntity.ok(pieceHead);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePieceHead(@PathVariable("id")int id){
		piece_head_service.get(id).orElseThrow(()->new NotFoundException("there is no piece head with this id"));
		piece_head_service.delete(id);
		return ResponseEntity.ok("piece deleted successfully");
	}
}
