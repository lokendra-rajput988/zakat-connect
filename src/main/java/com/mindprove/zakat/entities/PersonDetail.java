package com.mindprove.zakat.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
@Entity
@Data
@SequenceGenerator(name="PersonDetailSequence",sequenceName = "person+detail_id+seq",allocationSize = 1)
public class PersonDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PersonDetailSequence")
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
	private String confirmPassword;
	@Column
	private String mobile;
	@Column
	private Integer age;
	@Column
	private String gender;
	@Column
	private String description;
	@Column
	private boolean isActive;
	@CreationTimestamp
	@Column(updatable = false)
	private Date createdAt;
	@UpdateTimestamp
	@Column
	private Date updatedAt;
}
