package org.dance.query;

import java.sql.SQLException;
import java.util.EnumSet;
import java.util.List;

import org.dance.embd.MaritalStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonCtrl {

	@Autowired
	PersonService personService;
	
	@Autowired
	PersonPojo personPojo;
	
	@Autowired
	RetryService retryService;

	@PostMapping("/getPersons")
	public @ResponseBody List<Person> getPersons() {
		return personService.getAllPersons();
	}

	@PostMapping("/insertPersons")
	public @ResponseBody void insert() {
		personService.insert();
	}

	@PostMapping("/getEnums")
	public @ResponseBody EnumSet<MaritalStatus> getEnumSet() {
		EnumSet<MaritalStatus> enumSet = EnumSet.allOf(MaritalStatus.class);
		return enumSet;
	}
	
	@GetMapping("/checkCompo/{first}")
	public @ResponseBody void checkCompo(@PathVariable("first") String name){
		personPojo.setFirstName(name);
		personService.check(personPojo);
		System.out.println(personPojo.getFirstName()+" "+personPojo.getLastName());
	}
	
	@GetMapping("/checkCompo")
	public @ResponseBody void checkCompo(){
		personService.check(personPojo);
		System.out.println(personPojo.getFirstName()+" "+personPojo.getLastName());
	}

	@GetMapping("/retry")
	public @ResponseBody void retry() {
		try {
			retryService.retryService("select * from person");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
