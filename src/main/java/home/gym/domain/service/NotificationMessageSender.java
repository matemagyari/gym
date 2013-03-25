package home.gym.domain.service;

import home.gym.domain.model.NotificationMessage;
import home.gym.domain.model.core.contact.Contact;
import home.gym.domain.service.sender.core.ContactTypeSpecificSender;
import home.gym.domain.service.sender.core.ContactTypeSpecificSenderProvider;
import home.gym.domain.service.sender.core.MessageSenderContext;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class NotificationMessageSender {

	@Resource
	private ContactTypeSpecificSenderProvider contactTypeSpecificSenderProvider;
	@Resource
	private MessageSenderContext messageSenderContext;

	public void send(NotificationMessage notificationMessage) {

		for (Contact contact : notificationMessage.getContacts()) {
			
			ContactTypeSpecificSender sender = contactTypeSpecificSenderProvider
					.getSender(contact.getClass());
			
			messageSenderContext.send(contact, notificationMessage.getMessage(), sender);
		}

	}

}
