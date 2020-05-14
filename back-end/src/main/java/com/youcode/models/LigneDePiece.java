package com.youcode.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.youcode.config.AuditModel;
import com.youcode.exceptions.AttributeMissingException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "ligne_de_piece")
public class LigneDePiece extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ligne_id")
	private int id;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "total_price", nullable = false)
	private float total_price;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
//	@ManyToOne
//	@JoinColumn(name = "piece_id", nullable = false)
//	private Piece piece;
//	
	
	public void checkAttributes() {
		if(this.product==null) throw new AttributeMissingException("the product is missing in the ressource sent");
		if(this.client==null) throw new AttributeMissingException("the client is missing in the ressource sent");
//		if(this.piece==null) throw new AttributeMissingException("the piece is missing in the ressource sent");
	}
	
}
