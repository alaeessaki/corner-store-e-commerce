package com.youcode.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.youcode.exceptions.AttributeMissingException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "piece_heads")
public class PieceHead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "piece_head_id")
	private int id;
	
	@Column(name = "ship_name", nullable = false)
	private String ship_name;
	
	@Column(name = "ship_adress", nullable = false)
	private String ship_adress;
	
	@Column(name = "ship_adress2", nullable = true)
	private String ship_adress2;
	
	@Column(name = "zip", nullable = false)
	private String zip;
	
	@Column(name = "phone", nullable = true)
	private String phone;
	
	@Column(name = "is_shipped", columnDefinition = "boolean default false")
	private boolean is_shipped;
	
	@ManyToOne
	@JoinTable(
			name = "piece_shipping",
			joinColumns = @JoinColumn(name="piece_id"),
			inverseJoinColumns = @JoinColumn(name="shipping_id"))	
	private Shipping Shipping;
	
	@ManyToOne
	@JoinColumn(name = "piece_type_id" , nullable = false)
	private PieceType piece_type;
	
	@ManyToOne
	@JoinColumn(name = "piece_id", nullable = false)
	private Piece piece;
	
	
	public void checkAttributes() {
		if(this.piece==null) throw new AttributeMissingException("the piece is missing in the ressource sent");
		if(this.piece_type==null) throw new AttributeMissingException("the piece_type is missing in the ressource sent");
		if(this.Shipping==null) throw new AttributeMissingException("the shipping is missing in the ressource sent");

	}
}
