package home.gym.domain.core.service;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.domain.core.model.NotificationMessage;
import home.gym.domain.core.service.sender.core.ContactTypeSpecificSender;
import home.gym.domain.core.service.sender.core.ContactTypeSpecificSenderProvider;
import home.gym.domain.core.service.sender.core.MessageSenderContext;

import javax.annotation.Resource;
import javax.inject.Named;

@Named
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
