package com.mindprove.zakat.service;

import java.util.List;

import com.mindprove.zakat.dto.PersonDto;

public interface PersonService {

	PersonDto createPerson(PersonDto personDetailDto);
	PersonDto getPersonById(long id);
	PersonDto updatePersonById(long id,PersonDto personDetailDto);
	boolean deletePersonById(long id);
	List<PersonDto> getAllPerson();
}
