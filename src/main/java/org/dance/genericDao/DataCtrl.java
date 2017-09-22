package org.dance.genericDao;

import java.util.List;

import org.dance.query.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataCtrl {

	@Autowired
	PersonDao personDao;

	@PostMapping("/getPersonList")
	public @ResponseBody List<Person> getPersons() {
		return personDao.findAll();
	}
}
