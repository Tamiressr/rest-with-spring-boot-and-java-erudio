package br.com.erudio.services;

import br.com.erudio.controller.PersonController;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.RequiredObjectIsnullException;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
	@Autowired
	private PersonRepository repository;
	@Autowired
	private PersonMapper personMapper;
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public PersonVO findById(Long id) {
		logger.info("Finding one person");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		PersonVO vo = DozerMapper.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

		return vo;
	}

	public List<PersonVO> findAll() {
		logger.info("Finding all peoples");
		var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
		persons.stream().forEach(personVO -> {
			personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		});
		return persons;
	}

	public PersonVO create(PersonVO person) {

		if (person == null) {
			throw new RequiredObjectIsnullException();
		}
		logger.info("Creating one person!!!");
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public PersonVO update(PersonVO person) {

		if (person == null) {
			throw new RequiredObjectIsnullException();
		}
		logger.info("updating one person!!!");
		var p = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		p.setFirstName(person.getFirstName());
		p.setLastName(person.getLastName());
		p.setAddress(p.getAddress());
		p.setGender(person.getGender());

		var vo = DozerMapper.parseObject(repository.save(p), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting one person!!!");
		var p = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(p);
	}

	public PersonVOV2 createv2(PersonVOV2 person) {
		logger.info("Creating one person!!!");

		var entity = personMapper.convertVoToEntity(person);
		var vo = personMapper.convertEntityToVO(repository.save(entity));
		return vo;
	}
}
