package com.youcode.models;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "payment_types")
public class PaymentType extends AuditModel{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int id;
	
	@Column(name = "label", nullable = false)
	private String label;
	
	@OneToMany(mappedBy = "payment_type", cascade = CascadeType.ALL)
	private List<Payment> payments;
}
