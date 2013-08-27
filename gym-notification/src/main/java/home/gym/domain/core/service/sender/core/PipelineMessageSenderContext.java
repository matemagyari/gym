package home.gym.domain.core.service.sender.core;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.domain.core.model.MessageText;
import home.gym.domain.pipeline.Pipeline;
import home.gym.domain.pipeline.PipelineManager;

import javax.annotation.Resource;

public class PipelineMessageSenderContext implements MessageSenderContext {

    private final MessageSenderContext messageSenderContext;
    @Resource
    private PipelineManager pipelineManager;
    @Resource
    private MessageSendCommandBuilder messageSendCommandBuilder;
    private final Pipeline pipeline;
    
    public PipelineMessageSenderContext(MessageSenderContext messageSenderContext) {
        this.messageSenderContext = messageSenderContext;
        pipeline = this.pipelineManager.createPipeline();
    }


    @Override
    public <T extends Contact> void send(T contact, MessageText message, ContactTypeSpecificSender<T> sender) {
        
        MessageSendCommand<T> command = messageSendCommandBuilder.build(contact, message, sender, messageSenderContext);
        pipeline.putIn(command);
    }
}
