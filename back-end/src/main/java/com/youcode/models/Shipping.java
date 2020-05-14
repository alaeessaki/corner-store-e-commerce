package com.youcode.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.youcode.config.AuditModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "shippings")
public class Shipping extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipping_id")
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name; 
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "price", nullable = false)
	private float price;
}
