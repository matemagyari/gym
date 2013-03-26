package home.gym.calendar.api.model.core.contact;

import java.util.ArrayList;
import java.util.List;

public class Contacts {
	
	private List<Contact> contacts;

	public Contacts(Contact... contacts) {

		this.contacts = new ArrayList<Contact>();
		for (Contact contact : contacts) {
			this.contacts.add(contact);
		}
	}

	public List<Contact> toList() {
		return new ArrayList<Contact>(contacts);
	}

	
}
