package home.gym.domain.model;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.calendar.api.model.core.contact.Contacts;

import java.util.List;

public class MessageDestination  {

	private final Contacts contacts;

	public MessageDestination(Contacts contacts) {
		this.contacts = contacts;
	}

	public List<Contact> getContacts() {
		return contacts.toList();
	}

}
