package br.com.erudio.controller;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.services.PersonService;
import br.com.erudio.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person/v1")
public class PersonController {
@Autowired
	private PersonService personService;
	@GetMapping(value="/{id}", produces ={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public PersonVO findById(@PathVariable(value="id")Long id){

		PersonVO person=personService.findById(id);
		return person;
	}
	@GetMapping( produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public List<PersonVO> findAll(){

		List<PersonVO> persons=personService.findAll();
		return persons;
	}
	@PostMapping( produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public PersonVO create(@RequestBody PersonVO person){
		return personService.create(person);
	}
	@PutMapping(produces ={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			consumes ={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML} )
	public PersonVO update(@RequestBody PersonVO person){
		return personService.create(person);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id")Long id){
		 personService.delete(id);
		 return ResponseEntity.noContent().build();

	}
	@PostMapping( value="/v2",produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			consumes ={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML} )
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person){

		return personService.createv2(person);
	}

}
