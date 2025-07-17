package com.mindprove.zakat.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
@Entity
@Data
@SequenceGenerator(name="AddressSequence",sequenceName = "address_id_seq",allocationSize = 1)
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "AddressSequence")
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
	@JoinColumn(name="person_detail_id")
	private PersonDetail personDetail;

	
}
