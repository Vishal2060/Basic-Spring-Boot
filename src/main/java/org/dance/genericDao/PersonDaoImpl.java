package org.dance.genericDao;

import org.dance.query.Person;
import org.springframework.stereotype.Repository;

@Repository("PersonDao")
public class PersonDaoImpl extends AbstractDaoImpl<Person, Integer> implements PersonDao {

	public PersonDaoImpl() {
		super(Person.class);
	}

}
