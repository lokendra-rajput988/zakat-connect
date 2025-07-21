package com.mindprove.zakat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String mobile;
	
	@Column
	private Integer age;
	
	@Column
	private String gender;
	
	@Column
	private String description;
	
	@Column
	private boolean isActive=true;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column
	private Date updatedAt;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "person")
	private List<Address> address= new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "person")
	private List<PersonRole> personRoles= new ArrayList<PersonRole>();
	
}
