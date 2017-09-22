package org.dance.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class PersonRepositoryRestController {

	@Autowired
	PersonRepo personRepo;

	@RequestMapping(value = "/persons/search/getAllPersons", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getAll() {

		List<Person> producers = personRepo.getAll("vishal");

		Resources<Person> resources = new Resources<Person>(producers);
		resources.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(PersonRepositoryRestController.class).getAll()).withSelfRel());

		return ResponseEntity.ok(resources);
	}

}
