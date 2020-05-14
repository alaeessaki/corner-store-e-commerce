package com.youcode.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.config.AuditModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "images")
public class Image extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private int id;
	
	@Column(name = "src", nullable = false)
	private String src;
	
	@Column(name = "alt", nullable = true)
	private String alt;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	@PrePersist
	void preInsert() {
	   if (this.alt == null)
	       this.alt = this.product.getName() + " image";
	}
}
