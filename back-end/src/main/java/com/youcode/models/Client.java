package com.youcode.models;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.dto.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AttributeOverride(name="user_id", column=@Column(name="client_id"))
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "clients")
public class Client extends User{

	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "phone", nullable = true)
	private String phone;
	
	@Column(name = "birth_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date birth_date;
	
	@Column(name = "country", nullable = true)
	private String country;
	
	@Column(name = "city", nullable = true)
	private String city;
	
	@Column(name = "zip", nullable = true)
	private String zip;
	
	@Column(name = "adress1", nullable = true)
	private String adress1;

	@Column(name = "adress2", nullable = true)
	private String adress2;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Coupon> coupons;
	
	@OneToMany(mappedBy = "client")
	private List<LigneDePiece> lignes_de_piece;

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Review> reviews;
}
