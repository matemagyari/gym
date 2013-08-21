package home.gym.infrastructure.service.sender.email;

import home.gym.domain.email.model.EmailMessage;
import home.gym.domain.email.service.EmailSenderAdapter;

import javax.inject.Named;

@Named
public class DefaultEmailSenderAdapter implements EmailSenderAdapter {

	@Override
	public void send(EmailMessage emailMessage) {
		
	}

}
