package home.gym.domain.core.service.sender.core;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.domain.core.model.MessageText;

import javax.inject.Named;

@Named
class MessageSendCommandBuilder {

    <T extends Contact> MessageSendCommand<T> build(T contact, MessageText message, ContactTypeSpecificSender<T> sender,
            MessageSenderContext messageSenderContext) {

        return new MessageSendCommand<T>(contact, message, sender, messageSenderContext);
    }

}
