package com.mindprove.zakat.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PersonDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile; 
	private Integer age;
	private String gender;
	private String description;
	private boolean isActive;
	private List<AddressDto> address = new ArrayList<>();
	private List<Long> roleIds=new ArrayList<>();
}
