package org.dance.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

@RestController
public class MailController {

	@Autowired
	MailComponent mailComponent;
	
	@GetMapping("/simpleMail")
	public String sendMail() {
		mailComponent.setSimpleMail("Test Mail", "Hello World", "vishaljadhav2060@gmail.com");
		new Thread(mailComponent::sendSimpleMail).run();
		return "Simple Mail Send Successfully";
	}
	
	@GetMapping("/mimeMail")
	public String sendMime() {
		
		Context context = new Context();
		context.setVariable("userName", "Vishal");
		
		mailComponent.setMimeMail("Test MIME Mail", context, "MailTemplate/template","vishaljadhav2060@gmail.com");
		new Thread(mailComponent::sendMimeMail).run();
		return "MIME Mail Send Successfully";
	}
	
}
