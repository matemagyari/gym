package home.gym.domain.email.service;

import home.gym.calendar.api.model.core.contact.EmailAddress;
import home.gym.domain.core.model.MessageText;
import home.gym.domain.core.service.sender.core.ContactTypeSpecificSender;
import home.gym.domain.email.model.EmailMessage;

import javax.annotation.Resource;
import javax.inject.Named;

@Named
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
