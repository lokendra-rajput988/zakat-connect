package com.mindprove.zakat.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column
	private String street;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String country;
	
	@Column
	private Integer zipCode;
	
	@Column(updatable = false)
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	@Column
	private Date updatedAt;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	@JsonIgnore
	private Person person;

	
}
