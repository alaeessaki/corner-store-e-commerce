package com.youcode.models;

import java.util.Base64;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.config.AuditModel;
import com.youcode.exceptions.CouponNotValidException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "coupons")
public class Coupon extends AuditModel{

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
//	@SequenceGenerator(name = "node_seq", sequenceName = "uuid", allocationSize = 1)
//	@Column(name = "coupon_id", columnDefinition = "BINARY(16)")
//	private UUID uuid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@Column(name = "base", nullable = false, updatable = false, unique = true)
	private String base;
	
	@Column(name = "code", nullable = false, unique = true)
	@Lob
	private String code;
	
	@Column(name = "discount_percent", nullable = false)
	private float discount_percent;
	
	@Column(name = "status", columnDefinition = "boolean default false")
	private boolean status;
	
	@Column(name = "start_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date start_date;
	
	@Column(name = "end_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date end_date;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "piece_id", nullable = true)
	private Piece piece;
	
	public void expire() {
		this.status = true;
	}
	
	@PrePersist
	void generateCode() {
		String first_layer = "bobostore"+"-,-"+client.getId()+"-,-";
		String second_layer = String.valueOf(Math.random());
		this.base = Base64.getEncoder().encodeToString(second_layer.getBytes());
		String third_layer = this.base+"-,-"+"storebobo";
		String layer = first_layer+this.base+third_layer;
		String code = Base64.getEncoder().encodeToString(layer.getBytes());
		this.code = code;
	}
	
	public boolean checkValidation() {
		String first_layer = "bobostore"+"-,-"+client.getId()+"-,-";
		String second_layer = this.base;
		String third_layer = this.base+"-,-"+"storebobo";
		String layer = first_layer+second_layer+third_layer;
		try{
			byte[] decodedBytes = Base64.getDecoder().decode(this.code);
			String decodedString = new String(decodedBytes);
			if(decodedString.equals(layer)) return true;
		}catch(IllegalArgumentException e) {
			throw new CouponNotValidException("this coupon is not Valid"); 
		}
		return false;
	}
	
//	public boolean checkExpiration() {
//		
//	}
}
