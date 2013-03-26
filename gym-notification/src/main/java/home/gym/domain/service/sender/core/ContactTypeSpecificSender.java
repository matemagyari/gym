package home.gym.domain.service.sender.core;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.domain.model.MessageText;

public interface ContactTypeSpecificSender<T extends Contact> {

	void send(final T contact, final MessageText message);

	Class<T> getContactType();

}
