package com.mindprove.zakat.services;

import java.lang.System.Logger;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindprove.zakat.dtos.PersonDetailDto;
import com.mindprove.zakat.entities.PersonDetail;
import com.mindprove.zakat.mapper.PersonDetailMapper;
import com.mindprove.zakat.repositories.PersonDetailRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonDetailServiceImpl implements PersonDetailService {
	
	private PersonDetailRepository personDetailRepository;
	private PersonDetailMapper personDetailMapper;

	@Override
	public PersonDetailDto createPerson(PersonDetailDto personDetailDto) {
        log.info("create person method called");
        PersonDetail personDetail =personDetailMapper.toEntity(personDetailDto);
        Optional<PersonDetail> personDetailByEmail = personDetailRepository.findByEmail(personDetail.getEmail());
		return null;
	}

	@Override
	public PersonDetailDto getPersonById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDetailDto updatePersonById(long id, PersonDetailDto personDetailDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePersonById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PersonDetailDto> getAllPerson() {
		// TODO Auto-generated method stub
		return null;
	}

}
