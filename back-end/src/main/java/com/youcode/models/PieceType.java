package com.youcode.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.youcode.config.AuditModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "piece_types")
public class PieceType extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "piece_type_id")
	private int id;
	
	@Column(name = "label", nullable = false)
	private String label;
	
	@Column(name="last_inc_id", nullable = false)
	private int last_inc;
	
	@OneToMany(mappedBy = "piece_type")
	private List<PieceHead> piece_heads;
	
	
	public void incId() {
		this.last_inc = this.last_inc + 1;
	}
}
