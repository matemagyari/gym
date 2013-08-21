package home.gym.domain.email.service;

import home.gym.calendar.api.model.core.contact.EmailAddress;
import home.gym.domain.core.model.MessageText;
import home.gym.domain.email.model.EmailMessage;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

@Named
public class EmailMessageFactory {

	@Value("${email.subject}")
	private String subject;

	public EmailMessage build(EmailAddress emailAddress, MessageText message) {
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setTo(emailAddress.textValue());
		emailMessage.setBody(message.toString());
		emailMessage.setSubject(subject);
		return emailMessage;
	}

}
