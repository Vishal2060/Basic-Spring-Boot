package org.dance.query;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepo personRepo;

	@Override
	public List<Person> getAllPersons() {
		Person person = new Person();
		person.setId(2);
		Example<Person> example = Example.of(person);

		personRepo.printMessage();

		return personRepo.findAll(example);
	}

	@Override
	public void insert() {
		//Person person1 = personRepo.findOne(1);
		//person1.setId(1);
		//person1.setName("Vishal1");
		//person1.setNumber("0987612345");
		//personRepo.save(person1);
		
		
		//Person person2 = new Person();
		//person2.setId(2);
		//person2.setName("V");
		//person2.setNumber("123456789342");
		//personRepo.save(person2);
	}

	@Override
	public void check(PersonPojo personPojo) {
		personPojo.setLastName("Jadhav");
	}

}
