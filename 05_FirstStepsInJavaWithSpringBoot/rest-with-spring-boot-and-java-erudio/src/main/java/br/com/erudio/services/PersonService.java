package br.com.erudio.services;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
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
    @Autowired
    private PersonMapper personMapper;
    private Logger logger=Logger.getLogger(PersonService.class.getName());

public PersonVO findById(Long id){
    logger.info("Finding one person");
    var entity=repository.findById(id).orElseThrow(()->
            new ResourceNotFoundException("No records found for this ID!"));
return DozerMapper.parseObject( entity ,PersonVO.class);
}
    public List<PersonVO> findAll() {
        logger.info("Finding all peoples");
        List<PersonVO> persons = DozerMapper.parseListObjects(repository.findAll(),PersonVO.class);
        return persons;
    }
    public PersonVO create(PersonVO person){
        logger.info("Creating one person!!!");

        var entity=DozerMapper.parseObject(person,Person.class);
       var vo= DozerMapper.parseObject(repository.save(entity),PersonVO.class) ;
        return vo;
    }
    public PersonVO update(PersonVO person){
        logger.info("updating one person!!!");
       var p=repository.findById(person.getId()).orElseThrow(()->new ResourceNotFoundException("No records found for this ID!"));
       p.setFirstName(person.getFirstName());
       p.setLastName(person.getLastName());
       p.setAddress(p.getAddress());
       p.setGender(person.getGender());

        var vo= DozerMapper.parseObject(repository.save(p),PersonVO.class) ;
        return vo;
    }
    public void delete (Long id){
        logger.info("Deleting one person!!!");
        var p=repository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(p);
    }

    public PersonVOV2 createv2(PersonVOV2 person) {
        logger.info("Creating one person!!!");

        var entity=personMapper.convertVoToEntity(person);
        var vo= personMapper.convertEntityToVO(repository.save(entity));
        return vo;
    }
}
