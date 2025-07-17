package com.mindprove.zakat.services;

import java.util.List;

import com.mindprove.zakat.dtos.PersonDetailDto;

public interface PersonDetailService {

	PersonDetailDto createPerson(PersonDetailDto personDetailDto);
	PersonDetailDto getPersonById(long id);
	PersonDetailDto updatePersonById(long id,PersonDetailDto personDetailDto);
	boolean deletePersonById(long id);
	List<PersonDetailDto> getAllPerson();
}
