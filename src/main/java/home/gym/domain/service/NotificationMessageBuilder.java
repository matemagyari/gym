package home.gym.domain.service;

import javax.annotation.Resource;

import home.gym.domain.model.MessageDestination;
import home.gym.domain.model.MessageText;
import home.gym.domain.model.NotificationMessage;
import home.gym.domain.model.NotificationMessageTemplateRepository;
import home.gym.domain.model.event.EventNotification;
import home.gym.domain.model.templates.NotificationMessageTemplate;

import org.springframework.stereotype.Component;

@Component
public class NotificationMessageBuilder {
	
	@Resource
	private NotificationMessageTemplateRepository notificationMessageTemplateRepository;

	public NotificationMessage build(EventNotification eventNotification) {
		
		
		NotificationMessageTemplate messageTemplate = notificationMessageTemplateRepository
				.find(eventNotification.getType());
		
		MessageText messageText = messageTemplate
				.generateMessageText(eventNotification);
		
		MessageDestination destination = new MessageDestination(
				eventNotification.getMemberContacts());
		
		return new NotificationMessage(destination, messageText);
	}

}
