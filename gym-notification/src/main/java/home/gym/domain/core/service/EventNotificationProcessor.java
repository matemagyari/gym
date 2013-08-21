package home.gym.domain.core.service;

import home.gym.calendar.api.model.event.EventNotification;
import home.gym.domain.core.model.NotificationMessage;

import javax.annotation.Resource;
import javax.inject.Named;

@Named
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
