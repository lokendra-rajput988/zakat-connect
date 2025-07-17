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
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private String mobile;
	private Integer age;
	private String gender;
	private String description;
	private boolean isActive;
	@CreationTimestamp
	@Column(updatable = false)
	private Date createdAt;
	@UpdateTimestamp
	private Date updatedAt;
}
