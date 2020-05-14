package com.youcode.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.config.AuditModel;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@ToString(exclude = {"parent"})
@Table(name = "categories")
public class Category extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int id;
	
	@Column(name = "label")
	private String label;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id", referencedColumnName = "category_id", nullable = true)
	private Category parent;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	@OneToMany(mappedBy = "parent")
	private List<Category> sub_categories;
	
	
	public void checkProperties() {
		if(this.products==null) {
			List<Product> products = new ArrayList<Product>();
			this.setProducts(products);
		}
		if(this.sub_categories==null) {
			List<Category> sub_categories = new ArrayList<Category>();
			this.setSub_categories(sub_categories);;
		}
	}
	
}
