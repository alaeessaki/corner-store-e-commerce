package com.youcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.exceptions.NotFoundException;
import com.youcode.models.Client;
import com.youcode.models.Coupon;
import com.youcode.services.interfaces.ClientServiceInterface;
import com.youcode.services.interfaces.CouponServiceInterface;


@RestController
@CrossOrigin
@RequestMapping("api")
public class CouponController {

	@Autowired
	CouponServiceInterface coupons_service;
	
	@Autowired
	ClientServiceInterface client_service;
	
	@GetMapping("/coupons")
	public ResponseEntity<List<Coupon>> getAll(){
		return ResponseEntity.ok(coupons_service.getAll());
	}
	
	@GetMapping("/coupons/{id}")
	public ResponseEntity<Coupon> getCoupon(@PathVariable("id")int id){
		Coupon coupon = coupons_service.get(id).orElseThrow(()->new NotFoundException("there is no coupon with this id"));
		return ResponseEntity.ok(coupon);
	}
	
	@GetMapping("/coupons/{code}/status")
	public ResponseEntity<String> checkValid(@PathVariable("code")String code){
		Coupon coupon = coupons_service.getByCode(code).orElseThrow(()->new NotFoundException("there is no coupon with this code"));
		boolean isValid = coupon.checkValidation();
		return ResponseEntity.ok("is valid :" + isValid);
	}
	
	@PostMapping("/coupons/client/{client_id}")
	public ResponseEntity<Coupon> addCoupon(@PathVariable("client_id")int client_id,@RequestBody Coupon coupon ){
		Client client = client_service.get(client_id).orElseThrow(()->new NotFoundException("there is no Client with this id"));
		coupon.setClient(client);
		coupons_service.add(coupon);
		return ResponseEntity.ok(coupon);
	}
	
	@DeleteMapping("/admins/coupons/{id}")
	public ResponseEntity<String> deleteCoupon(@PathVariable("id")int id){
		coupons_service.get(id).orElseThrow(()->new NotFoundException("there is no coupon with this id"));
		coupons_service.delete(id);
		return ResponseEntity.ok("coupon deleted successfully");
	}
}
