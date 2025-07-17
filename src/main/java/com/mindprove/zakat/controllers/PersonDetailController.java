package com.mindprove.zakat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mindprove.zakat.dtos.PersonDetailDto;
import com.mindprove.zakat.response.ResponseDTO;
import com.mindprove.zakat.services.PersonDetailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/person-detail/")
@Slf4j
@RequiredArgsConstructor
public class PersonDetailController {

	//http://localhost:9090/api/person-detail/
	private final PersonDetailService personDetailService;
	
	@PostMapping("createPerson")
	public ResponseEntity<ResponseDTO> createPerson(@RequestBody PersonDetailDto personDetailDto){
		log.info("Post API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", personDetailService.createPerson(personDetailDto) , HttpStatus.CREATED));
	}
	
	@GetMapping("getPersonById/{id}")
	public ResponseEntity<ResponseDTO> getPersonById(@PathVariable long id){
		log.info("Get API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", personDetailService.getPersonById(id) , HttpStatus.OK));
	}
	
	@GetMapping("getAllPerson")
	public ResponseEntity<ResponseDTO> getAllPerson(){
		log.info("Get API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", personDetailService.getAllPerson(), HttpStatus.OK));
	}
	
	@PatchMapping("updatePersonById/{id}")
	public ResponseEntity<ResponseDTO> updatePersonById(@PathVariable long id,@RequestBody PersonDetailDto personDetailDto){
		log.info("Patch API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", personDetailService.updatePersonById(id, personDetailDto), HttpStatus.OK));
	}
	
	@DeleteMapping("deletePersonById/{id}")
	public ResponseEntity<ResponseDTO> deletePersonById(@PathVariable long id){
		log.info("Delete API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", personDetailService.deletePersonById(id) , HttpStatus.OK));
	}
}
