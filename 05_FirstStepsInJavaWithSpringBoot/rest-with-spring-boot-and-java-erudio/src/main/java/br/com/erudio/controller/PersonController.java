package br.com.erudio.controller;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.services.PersonService;
import br.com.erudio.util.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/person/v1")
@Tag(name="people",description="Endpoints for managing people")
public class PersonController {
@Autowired
	private PersonService personService;
	@GetMapping(value="/{id}", produces ={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation( summary="Find one Person", description="Find one Person",tags={"People"},
			responses={
					@ApiResponse(description = "Sucess",responseCode= "200",content =
							@Content(schema=@Schema(implementation = PersonVO.class)
							)
					),
					@ApiResponse(description = "No content",responseCode = "204",content = @Content),
					@ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
					@ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
					@ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
					@ApiResponse(description = "Internal Error",responseCode = "500",content = @Content)

			})
	public PersonVO findById(@PathVariable(value="id")Long id){

		PersonVO person=personService.findById(id);
		return person;
	}
	@GetMapping( produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation( summary="Finds all People", description="Finds All People",tags={"People"},
	responses={
			@ApiResponse(description = "Sucess",responseCode= "200",content = {
					@Content(mediaType="application/json",array=@ArraySchema(schema=@Schema(implementation = PersonVO.class))
					)
			}),
			@ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
			@ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
			@ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
			@ApiResponse(description = "Internal Error",responseCode = "500",content = @Content)

	})
	public List<PersonVO> findAll(){

		List<PersonVO> persons=personService.findAll();
		return persons;
	}
	@PostMapping( produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation( summary="Adds a new Person", description="Adds a new Person by passing in JSON, XML or YML representation of a person ",tags={"People"},
			responses={
					@ApiResponse(description = "Sucess",responseCode= "200",content =
					@Content(schema=@Schema(implementation = PersonVO.class)
					)
					),
					@ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
					@ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
					@ApiResponse(description = "Internal Error",responseCode = "500",content = @Content)

			})
	public PersonVO create(@RequestBody PersonVO person){
		return personService.create(person);
	}
	@PutMapping(produces ={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			consumes ={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML} )
	@Operation( summary="Updates a Person", description="Updates a Person by passing in JSON, XML or YML representation of a person",tags={"People"},
			responses={
					@ApiResponse(description = "Updated",responseCode= "200",content =
							@Content(schema=@Schema(implementation = PersonVO.class))
												),
					@ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
					@ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
					@ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
					@ApiResponse(description = "Internal Error",responseCode = "500",content = @Content)

			})
	public PersonVO update(@RequestBody PersonVO person){
		return personService.create(person);
	}
	@DeleteMapping(value="/{id}")
	@Operation( summary="Delete a Person", description="Delete a Person",tags={"People"},
			responses={
					@ApiResponse(description = "No content",responseCode= "204",content =
							@Content

					),
					@ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
					@ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
					@ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
					@ApiResponse(description = "Internal Error",responseCode = "500",content = @Content)

			})
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
