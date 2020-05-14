package com.youcode.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "piece")
public class Piece {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "piece_id")
	private int id;
	
	@Column(name = "dynamic_id", nullable = false)
	private String dynamic_id;
	
	@Column(name = "total_price", nullable = false)
	private float total_price;
	
	@OneToMany
	@JoinTable(
			name = "ligne_de_piece_piece",
			joinColumns = @JoinColumn(name="piece_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name="ligne_id", nullable = false))
	private List<LigneDePiece> ligne_de_pieces;
	
	@OneToMany(mappedBy = "piece")
	private List<Coupon> coupons;
	
	@ManyToOne
	@JoinTable(
			name = "piece_payment",
			joinColumns = @JoinColumn(name="piece_id"),
			inverseJoinColumns = @JoinColumn(name="payment_id"))
	private Payment payment;
	
	@OneToMany(mappedBy = "piece")
	private List<PieceHead> piece_heads;
	
	
	public void checkAttributes() {
		if(this.coupons==null) {
			List<Coupon> coupons = new ArrayList<Coupon>();
			this.setCoupons(coupons);
		}
		if(this.ligne_de_pieces==null) {
			List<LigneDePiece> ligne_de_pieces = new ArrayList<LigneDePiece>();
			this.setLigne_de_pieces(ligne_de_pieces);
		}
		if(this.piece_heads==null) {
			List<PieceHead> piece_heads = new ArrayList<PieceHead>();
			this.setPiece_heads(piece_heads);
		}
	}
	
	
}
