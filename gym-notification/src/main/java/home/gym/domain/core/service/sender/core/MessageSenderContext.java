package home.gym.domain.core.service.sender.core;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.domain.core.model.MessageText;

public interface MessageSenderContext {

    <T extends Contact> void send(T contact, MessageText message, ContactTypeSpecificSender<T> sender);

}