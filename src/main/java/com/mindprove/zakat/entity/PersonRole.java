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
public class PersonRole {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "role_id")
	private Role role;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="person_id")
	private Person person;
}
