package com.mindprove.zakat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@RequiredArgsConstructor
public class PersonDetailServiceImpl implements PersonDetailService {


	private final PersonDetailRepository personDetailRepository;
	private final PersonDetailMapper personDetailMapper;

	@Override
	public PersonDetailDto createPerson(PersonDetailDto personDetailDto) {
		log.info("create person method called");
		PersonDetail personDetail = personDetailMapper.toEntity(personDetailDto);
		Optional<PersonDetail> personDetailByEmail = personDetailRepository.findByEmail(personDetail.getEmail());
		if (personDetailByEmail.isEmpty() && personDetail.getPassword().equals(personDetail.getConfirmPassword())) {
			log.info("create person method completed");
			return personDetailMapper.toDTO(personDetailRepository.save(personDetail));
		} else {
			throw new AlreadyExistException("person email " + personDetail.getEmail() + " is already exist ", 409);
		}
	}

	@Override
	public PersonDetailDto getPersonById(long id) {
		log.info("get person by id method called");
		PersonDetail personDetail = personDetailRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("person id " + id + " is not found", 404));
		log.info("get person by id method completed");
		return personDetailMapper.toDTO(personDetail);
	}

	@Override
	public PersonDetailDto updatePersonById(long id, PersonDetailDto personDetailDto) {
		log.info("update person by id method called");
		PersonDetail personDetail = personDetailRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("person id " + id + " is not found", 404));
		personDetail.setFirstName(personDetailDto.getFirstName());
		personDetail.setLastName(personDetailDto.getLastName());
		personDetail.setEmail(personDetailDto.getEmail());
		personDetail.setPassword(personDetailDto.getPassword());
		personDetail.setConfirmPassword(personDetailDto.getConfirmPassword());
		personDetail.setAge(personDetailDto.getAge());
		personDetail.setGender(personDetailDto.getGender());
		personDetail.setMobile(personDetailDto.getMobile());
		personDetail.setActive(personDetailDto.isActive());
		personDetail.setDescription(personDetailDto.getDescription());
		log.info("update person by id method completed");
		return personDetailMapper.toDTO(personDetail);
	}

	@Override
	public boolean deletePersonById(long id) {
		log.info("delete person by id method called");
		PersonDetail personDetail = personDetailRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("person id " + id + " is not found", 404));
		personDetailRepository.delete(personDetail);
		log.info("delete person by id method completed");
		return true;
	}

	@Override
	public List<PersonDetailDto> getAllPerson() {
		log.info("get all person method called");
		List<PersonDetailDto> personList = personDetailRepository.findAll().stream().map(personDetailMapper::toDTO)
				.toList();
		log.info("get all person method completed");
		return personList;
	}

}
