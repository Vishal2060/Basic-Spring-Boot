package org.dance.validate;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactCtrl {

	Logger logger = LoggerFactory.getLogger(ContactCtrl.class);

	@PostMapping(value = "/validation")
	public @ResponseBody Contact submit(@Valid @RequestBody Contact contact, BindingResult result) {

		if (result.hasErrors()) {
			logger.error("Invalid Bean : Contact");
			//System.out.println(result.);
			return contact;
		}

		return contact;
	}
	
	@PostMapping(value = "/reponseEntity")
	public @ResponseBody ResponseEntity<?> validateResponse(@Valid @RequestBody Contact contact, BindingResult result) {

		if (result.hasErrors()) {
			logger.error("Invalid Response Bean : Contact");
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Record is not Accepted.");
		}

		return ResponseEntity.status(HttpStatus.OK).body(contact);
	}
}
