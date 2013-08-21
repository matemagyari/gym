package home.gym.domain.core.service.sender.core;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.domain.core.model.MessageText;
import home.gym.domain.core.service.sender.commandqueue.CommandProcessingQueue;

import javax.annotation.Resource;

public class CommandQueueingMessageSenderContext implements MessageSenderContext {

    private final MessageSenderContext messageSenderContext;
    @Resource
    private CommandProcessingQueue commandProcessingQueue;
    @Resource
    private MessageSendCommandBuilder messageSendCommandBuilder;
    
    public CommandQueueingMessageSenderContext(MessageSenderContext messageSenderContext) {
        this.messageSenderContext = messageSenderContext;
    }


    @Override
    public <T extends Contact> void send(T contact, MessageText message, ContactTypeSpecificSender<T> sender) {
        
        MessageSendCommand<T> command = messageSendCommandBuilder.build(contact, message, sender, messageSenderContext);
        commandProcessingQueue.putInQueue(command);
    }
}
