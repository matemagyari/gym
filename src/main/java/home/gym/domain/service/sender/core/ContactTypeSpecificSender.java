package home.gym.domain.service.sender.core;

import home.gym.domain.model.MessageText;
import home.gym.domain.model.core.contact.Contact;

public interface ContactTypeSpecificSender<T extends Contact> {

	void send(final T contact, final MessageText message);

	Class<T> getContactType();

}
