package home.gym.infrastructure.service.sender.email;

import org.springframework.stereotype.Component;

import home.gym.domain.service.sender.specific.email.EmailMessage;
import home.gym.domain.service.sender.specific.email.EmailSenderAdapter;

@Component
public class DefaultEmailSenderAdapter implements EmailSenderAdapter {

	@Override
	public void send(EmailMessage emailMessage) {
		
	}

}
