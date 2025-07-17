package com.mindprove.zakat.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PersonDetailDto {

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
	private Date createdAt;
	private Date updatedAt;
	private List<Long> addressId = new ArrayList<>();
}
