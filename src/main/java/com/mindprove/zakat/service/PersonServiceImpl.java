package com.mindprove.zakat.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mindprove.zakat.dto.PersonDto;
import com.mindprove.zakat.entity.Address;
import com.mindprove.zakat.entity.Person;
import com.mindprove.zakat.entity.PersonRole;
import com.mindprove.zakat.entity.Role;
import com.mindprove.zakat.exception.NotFoundException;
import com.mindprove.zakat.mapper.PersonMapper;
import com.mindprove.zakat.repository.AddressRepository;
import com.mindprove.zakat.repository.PersonRepository;
import com.mindprove.zakat.repository.PersonRoleRepository;
import com.mindprove.zakat.repository.RoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository perosnRepository;
	private final AddressRepository addressRepository;
	private final PersonRoleRepository personRoleRepository;
	private final PersonMapper personMapper;

	@Override
	public PersonDto createPerson(PersonDto personDto) {
		log.info("create person method called");
		Person person = personMapper.toEntity(personDto);
		Person save = perosnRepository.save(person);
		for (Address address : save.getAddress()) {
			address.setPerson(save);
			addressRepository.save(address);
		}
		System.out.println("jefudsbf");
		for (PersonRole personRole : save.getPersonRoles()) {
			System.out.println("personRole");
			personRole.setPerson(save);
			personRoleRepository.save(personRole);
		}

		log.info("create person method completed");
		return personMapper.toDTO(save);
	}

	@Override
	public PersonDto getPersonById(long id) {
		log.info("get person by id method called");
		Person person = perosnRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("person id " + id + " is not found", 404));
		log.info("get person by id method completed");
		return personMapper.toDTO(person);
	}

	@Override
	public PersonDto updatePersonById(long id, PersonDto personDto) {
		log.info("update person by id method called");
		Person person = perosnRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("person id " + id + " is not found", 404));
		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setEmail(personDto.getEmail());
		person.setPassword(personDto.getPassword());
		;
		person.setAge(personDto.getAge());
		person.setGender(personDto.getGender());
		person.setMobile(personDto.getMobile());
		person.setActive(personDto.isActive());
		person.setDescription(personDto.getDescription());
		// update address
		Person savedPerson = perosnRepository.save(person);
		log.info("update person by id method completed");
		return personMapper.toDTO(savedPerson);
	}

	@Override
	public boolean deletePersonById(long id) {
		log.info("delete person by id method called");
		Person person = perosnRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("person id " + id + " is not found", 404));
		perosnRepository.delete(person);
		log.info("delete person by id method completed");
		return true;
	}

	@Override
	public List<PersonDto> getAllPerson() {
		log.info("get all person method called");
		List<PersonDto> personDtos = perosnRepository.findAll().stream().map(personMapper::toDTO).toList();
		log.info("get all person method completed");
		return personDtos;
	}

}
