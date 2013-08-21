package home.gym.domain.email.service;

import home.gym.domain.email.model.EmailMessage;


public interface EmailSenderAdapter {

	void send(EmailMessage emailMessage);

}
