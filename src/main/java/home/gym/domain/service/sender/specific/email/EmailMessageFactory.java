package home.gym.domain.service.sender.specific.email;

import home.gym.domain.model.MessageText;
import home.gym.domain.model.core.contact.EmailAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
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
