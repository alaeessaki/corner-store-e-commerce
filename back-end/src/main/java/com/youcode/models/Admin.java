package com.youcode.models;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.youcode.dto.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AttributeOverride(name="user_id", column=@Column(name="admin_id"))
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "admins")
public class Admin extends User{
	
}
