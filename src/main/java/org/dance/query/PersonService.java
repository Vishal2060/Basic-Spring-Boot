package org.dance.query;

import java.util.List;


public interface PersonService {
	List<Person> getAllPersons();
	void insert();
	void check(PersonPojo personPojo);
}
