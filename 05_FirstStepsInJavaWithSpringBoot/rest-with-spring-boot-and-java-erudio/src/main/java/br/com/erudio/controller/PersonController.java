package br.com.erudio.controller;


import br.com.erudio.model.Person;
import br.com.erudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
@Autowired
	private PersonService personService;
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value="id")Long id){

		Person person=personService.findById(id);
		return person;
	}
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){

		List<Person> persons=personService.findAll();
		return persons;
	}
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE )
	public Person create(@RequestBody Person person){
		return personService.create(person);
	}
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE )
	public Person update(@RequestBody Person person){
		return personService.create(person);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id")Long id){
		 personService.delete(id);
		 return ResponseEntity.noContent().build();

	}

}
