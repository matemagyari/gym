package home.gym.domain.service.sender.core;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.domain.model.MessageText;

import org.springframework.stereotype.Component;

@Component
class MessageSendCommandBuilder {

    <T extends Contact> MessageSendCommand<T> build(T contact, MessageText message, ContactTypeSpecificSender<T> sender,
            MessageSenderContext messageSenderContext) {

        return new MessageSendCommand<T>(contact, message, sender, messageSenderContext);
    }

}
