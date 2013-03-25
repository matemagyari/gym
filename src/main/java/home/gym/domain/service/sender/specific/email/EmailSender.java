package home.gym.domain.service.sender.specific.email;

import home.gym.domain.model.MessageText;
import home.gym.domain.model.core.contact.EmailAddress;
import home.gym.domain.service.sender.core.ContactTypeSpecificSender;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class EmailSender implements ContactTypeSpecificSender<EmailAddress> {

	@Resource 
	private EmailSenderAdapter emailSenderAdapter;
	@Resource 
	private EmailMessageFactory emailMessageFactory;
	
	@Override
	public void send(EmailAddress emailAddress, MessageText message) {
		EmailMessage emailMessage = emailMessageFactory.build(emailAddress, message);
		emailSenderAdapter.send(emailMessage);
	}

	@Override
	public Class<EmailAddress> getContactType() {
		return EmailAddress.class;
	}

}
