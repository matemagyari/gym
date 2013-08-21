package home.gym.domain.core.service.sender.core;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.domain.core.model.MessageText;
import home.gym.domain.core.service.sender.commandqueue.Command;

class MessageSendCommand<T extends Contact> implements Command {
    
    final T contact;
    final MessageText message;
    final ContactTypeSpecificSender<T> sender;
    final MessageSenderContext messageSenderContext;

    MessageSendCommand(T contact, MessageText message, ContactTypeSpecificSender<T> sender, MessageSenderContext messageSenderContext) {
        this.contact = contact;
        this.message = message;
        this.sender = sender;
        this.messageSenderContext = messageSenderContext;
    }
    
    @Override
    public void execute() {
        messageSenderContext.send(contact, message, sender);
    }

}