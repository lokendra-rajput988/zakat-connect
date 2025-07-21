package com.mindprove.zakat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindprove.zakat.dto.PersonDto;
import com.mindprove.zakat.dto.ResponseDTO;
import com.mindprove.zakat.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/person/")
@Slf4j
@RequiredArgsConstructor
public class PersonController {

	//http://localhost:9090/api/v1/person/
	private final PersonService personService;
	
	@PostMapping
	public ResponseEntity<ResponseDTO> createPerson(@RequestBody PersonDto personDto){
		log.info("Post API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", personService.createPerson(personDto) , HttpStatus.CREATED));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseDTO> getPersonById(@PathVariable long id){
		log.info("Get API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", personService.getPersonById(id) , HttpStatus.OK));
	}
	
	@GetMapping
	public ResponseEntity<ResponseDTO> getAllPerson(){
		log.info("Get API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", personService.getAllPerson(), HttpStatus.OK));
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<ResponseDTO> updatePersonById(@PathVariable long id,@RequestBody PersonDto personDto){
		log.info("Patch API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", personService.updatePersonById(id, personDto), HttpStatus.OK));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseDTO> deletePersonById(@PathVariable long id){
		log.info("Delete API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", personService.deletePersonById(id) , HttpStatus.OK));
	}
}
