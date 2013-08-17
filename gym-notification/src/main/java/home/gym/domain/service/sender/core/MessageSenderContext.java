package home.gym.domain.service.sender.core;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.domain.model.MessageText;

public interface MessageSenderContext {

    <T extends Contact> void send(T contact, MessageText message, ContactTypeSpecificSender<T> sender);

}