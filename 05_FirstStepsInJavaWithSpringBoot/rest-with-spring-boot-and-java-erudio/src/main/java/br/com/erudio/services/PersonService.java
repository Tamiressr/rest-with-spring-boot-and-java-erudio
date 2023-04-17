package br.com.erudio.services;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;
    private Logger logger=Logger.getLogger(PersonService.class.getName());

public Person findById(Long id){
    logger.info("Finding one person");

return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID!"));
}
    public List<Person> findAll() {
        logger.info("Finding all peoples");
        List<Person> persons = repository.findAll();
        return persons;
    }
    public Person create(Person person){
        logger.info("Creating one person!!!");
        return repository.save(person);
    }
    public Person update(Person person){
        logger.info("updating one person!!!");
       var p=repository.findById(person.getId()).orElseThrow(()->new ResourceNotFoundException("No records found for this ID!"));
       p.setFirstName(person.getFirstName());
       p.setLastName(person.getLastName());
       p.setAddress(p.getAddress());
       p.setGender(person.getGender());

        return repository.save(p);
    }
    public void delete (Long id){
        logger.info("Deleting one person!!!");
        var p=repository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(p);
    }
}
