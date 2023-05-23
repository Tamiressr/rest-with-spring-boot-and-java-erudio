package unittest.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.RequiredObjectIsnullException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import br.com.erudio.services.PersonService;
import br.com.erudio.unittests.mapper.mocks.MockPerson;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

	MockPerson input;
	@InjectMocks
	PersonService service;
	
	@Mock
	PersonRepository repository;
	
	@BeforeEach
	void setUpMocks() throws Exception {
		input=new MockPerson();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {
		Person entity= input.mockEntity(1);
		entity.setId(1L);
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		var result=service.findById(1L);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
	
		assertTrue(result.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1",result.getAddress());
		assertEquals("First Name Test1",result.getFirstName());
		assertEquals("Last Name Test1",result.getLastName());
		assertEquals("Female",result.getGender());
	
	}

	@Test
	void testFindAll() {
		//fail("Not yet implemented");
		List<Person> list= input.mockEntityList();
	
		when(repository.findAll()).thenReturn(list);
		var people=service.findAll();

		assertNotNull(people);
		assertEquals(14,people.size());
		
		var personOne=people.get(1);
		assertNotNull(personOne);
		assertNotNull(personOne.getKey());
		assertNotNull(personOne.getLinks());
	
	
		assertTrue(personOne.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1",personOne.getAddress());
		assertEquals("First Name Test1",personOne.getFirstName());
		assertEquals("Last Name Test1",personOne.getLastName());
		assertEquals("Female",personOne.getGender());
		
		var personThree=people.get(3);
		assertNotNull(personThree);
		assertNotNull(personThree.getKey());
		assertNotNull(personThree.getLinks());
	
	
		assertTrue(personThree.toString().contains("links: [</person/v1/3>;rel=\"self\"]"));
		assertEquals("Addres Test3",personThree.getAddress());
		assertEquals("First Name Test3",personThree.getFirstName());
		assertEquals("Last Name Test3",personThree.getLastName());
		assertEquals("Female",personThree.getGender());
		
		var personEight=people.get(8);
		assertNotNull(personEight);
		assertNotNull(personEight.getKey());
		assertNotNull(personEight.getLinks());
	
	
		assertTrue(personEight.toString().contains("links: [</person/v1/8>;rel=\"self\"]"));
		assertEquals("Addres Test8",personEight.getAddress());
		assertEquals("First Name Test8",personEight.getFirstName());
		assertEquals("Last Name Test8",personEight.getLastName());
		assertEquals("Male",personEight.getGender());
	}

	@Test
	void testCreate() {
		Person entity= input.mockEntity(1);
		
		Person persisted=entity;
		persisted.setId(1L);
		
		PersonVO vo=input.mockVO(1);
		vo.setKey(1L);
		
		when(repository.save(entity)).thenReturn(persisted);
		
		var result=service.create(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
	
		assertTrue(result.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1",result.getAddress());
		assertEquals("First Name Test1",result.getFirstName());
		assertEquals("Last Name Test1",result.getLastName());
		assertEquals("Female",result.getGender());
	
	}
	@Test
	void testCreateWithNullPerson() {
	
		Exception exception= assertThrows(RequiredObjectIsnullException.class, ()->{service.create(null);});
		String expectedMessage="It is not allowed to persist a null object";
		String actualMessage=exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	
		
	}
	@Test
	void testUpdateWithNullPerson() {
		
		Exception exception= assertThrows(RequiredObjectIsnullException.class, ()->{service.update(null);});
		String expectedMessage="It is not allowed to persist a null object";
		String actualMessage=exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
		
		
	}

	@Test
	void testUpdate() {
	Person entity= input.mockEntity(1);
		
		Person persisted=entity;
		persisted.setId(1L);
		
		PersonVO vo=input.mockVO(1);
		vo.setKey(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);
		
		var result=service.update(vo);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
	
		assertTrue(result.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1",result.getAddress());
		assertEquals("First Name Test1",result.getFirstName());
		assertEquals("Last Name Test1",result.getLastName());
		assertEquals("Female",result.getGender());
	
	}

	@Test
	void testDelete() {
	
			Person entity= input.mockEntity(1);
				
				Person persisted=entity;
				persisted.setId(1L);
				when(repository.findById(1L)).thenReturn(Optional.of(entity));
				service.delete(1L);
					
	}


}
