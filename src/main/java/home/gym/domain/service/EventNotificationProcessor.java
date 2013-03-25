package home.gym.domain.service;

import home.gym.domain.model.NotificationMessage;
import home.gym.domain.model.event.EventNotification;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class EventNotificationProcessor {
	

	@Resource
	private NotificationMessageSender notificationMessageSender;
	@Resource
	private NotificationMessageBuilder notificationMessageBuilder;

	public void process(EventNotification eventNotification) {
		
		NotificationMessage notificationMessage = notificationMessageBuilder.build(eventNotification);
		
		notificationMessageSender.send(notificationMessage);
		
	}

}
