package com.youcode.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.config.AuditModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "reviews")
public class Review extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int id;
	
	@Column(name = "stars", nullable = false)
	private int stars;
	
	@Column(name = "content", nullable = false)
	@Lob
	private String content;
	
	@Column(name = "image", nullable = true)
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
}
