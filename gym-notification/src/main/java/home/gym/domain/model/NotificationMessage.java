package home.gym.domain.model;

import home.gym.calendar.api.model.core.contact.Contact;

import java.util.List;

public class NotificationMessage {

	private final MessageDestination destination;
	private final MessageText text;

	public NotificationMessage(MessageDestination destination, MessageText text) {
		this.destination = destination;
		this.text = text;
	}

	public List<Contact> getContacts() {
		return destination.getContacts();
	}

	public MessageText getMessage() {
		return text;
	}

}
