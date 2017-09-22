package org.dance.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.dance.jasper.ReportComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

@Component
public class MailComponent {

	private static final Logger logger = LoggerFactory.getLogger(ReportComponent.class);

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	private SpringTemplateEngine thymeleaf;

	private String subject;
	private String plainText;
	private String[] to;

	private Context context;
	private String template;

	public void setSimpleMail(String subject, String plainText, String ... to) {
		this.subject = subject;
		this.plainText = plainText;
		this.to = to;
	}

	public void setMimeMail(String subject, Context context, String template, String ... to) {
		this.subject = subject;
		this.context = context;
		this.template = template;
		this.to = to;
	}

	public void sendSimpleMail() {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(plainText);
		mailSender.send(message);

		logger.info(String.format("Simple mail \'%s\' send to " + to, subject));
	}

	@GetMapping("/mimeMsg")
	public void sendMimeMail()  {

		try {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(to);
		helper.setSubject(subject);

		String emailText = thymeleaf.process(template, context);
		helper.setText(emailText, true);
		mailSender.send(message);
		
		logger.info(String.format("MIME mail \'%s\' send to" + to, subject));

		}catch(MessagingException e) 
		{
			logger.error(String.format("MIME Mail \'%s\' could not be sent.",subject));
		}
	}
}
