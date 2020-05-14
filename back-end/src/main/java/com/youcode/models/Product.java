package com.youcode.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.config.AuditModel;
import com.youcode.exceptions.AttributeMissingException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "products")
public class Product extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	@Lob
	private String description;
	
	@Column(name = "sku", nullable = false)
	private String sku;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Column(name = "thumb", nullable = false)
	private String thumb;
	
	@Column(name = "stock", nullable = false)
	private int stock;
	
	@Column(name = "number_of_sells", nullable = true, columnDefinition = "integer default 0")
	private int sells;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "stars_collection_id")
	private StarsCollection stars_collection;
	
//	@Column(name = "rating", nullable = true)
//	private float rating;

	@Column(name = "live", nullable = true, columnDefinition = "boolean default false")
	private boolean live;

	@OneToMany(mappedBy = "product")
	private List<Review> reviews;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Image> images;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToMany
	@JoinTable(
			name = "product_size",
			joinColumns = @JoinColumn(name="product_id"),
			inverseJoinColumns = @JoinColumn(name="size_id"))
	private Collection<Size> sizes;
	
	@ManyToMany
	@JoinTable(
			name = "product_color",
			joinColumns = @JoinColumn(name="product_id"),
			inverseJoinColumns = @JoinColumn(name="color_id"))
	private Collection<Color> colors;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<LigneDePiece> lignes_de_piece;
	
	
	public float getRating() {
		return this.stars_collection.getRating();
	}
	
	public void checkAttributes() {
		if(this.colors==null) throw new AttributeMissingException("the product requires a list of colors");
		if(this.images==null) throw new AttributeMissingException("the product requires a list of images");
		if(this.category==null) throw new AttributeMissingException("the product needs to be in a category");
		if(this.sizes==null) throw new AttributeMissingException("the product needs a list of sizes");
		
		if(this.stars_collection==null) {
			StarsCollection stars_collection = new StarsCollection();
			this.setStars_collection(stars_collection);
		}
		if(this.reviews==null) {
			List<Review> reviews = new ArrayList<Review>();
			this.setReviews(reviews);
		}
		if(this.lignes_de_piece==null) {
			List<LigneDePiece> lignes_de_pieces = new ArrayList<LigneDePiece>();
			this.setLignes_de_piece(lignes_de_pieces);
		}
		
		for(Image image : this.images) {
			image.setProduct(this);
		}
		
	}
	

	
}
