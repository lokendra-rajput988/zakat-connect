package com.mindprove.zakat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindprove.zakat.dtos.PersonDetailDto;
import com.mindprove.zakat.entities.PersonDetail;
import com.mindprove.zakat.exceptions.AlreadyExistException;
import com.mindprove.zakat.exceptions.NotFoundException;
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
		log.info("createPerson method called");
		PersonDetail personDetail = personDetailMapper.toEntity(personDetailDto);
		Optional<PersonDetail> personDetailByEmail = personDetailRepository.findByEmail(personDetail.getEmail());
		if (personDetailByEmail.isEmpty() && personDetail.getPassword().equals(personDetail.getConfirmPassword())) {
			log.info("createPerson method completed");
			return personDetailMapper.toDTO(personDetailRepository.save(personDetail));
		} else {
			throw new AlreadyExistException("person email " + personDetail.getEmail() + " is already exist ", 409);
		}
	}

	@Override
	public PersonDetailDto getPersonById(long id) {
		log.info("getPersonById method called");
		PersonDetail personDetail=personDetailRepository.findById(id).orElseThrow(()-> new NotFoundException("person id "+id+" is not found", 404));
		log.info("getPersonById method completed");
		return personDetailMapper.toDTO(personDetail);
	}

	@Override
	public PersonDetailDto updatePersonById(long id, PersonDetailDto personDetailDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePersonById(long id) {
		log.info("deletePersonById method called");
		PersonDetail personDetail=personDetailRepository.findById(id).orElseThrow(()-> new NotFoundException("person id "+id+" is not found", 404));
		personDetailRepository.delete(personDetail);
		log.info("deletePersonById method completed");
		return true;
	}

	@Override
	public List<PersonDetailDto> getAllPerson() {
		log.info("getAllPerson method called");
		List<PersonDetailDto> personList=personDetailRepository.findAll().stream().map(personDetailMapper::toDTO).toList();
		log.info("getAllPerson method completed");
		return personList;
	}

}
