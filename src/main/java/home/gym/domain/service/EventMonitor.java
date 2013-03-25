package home.gym.domain.service;

import home.gym.domain.model.event.EventNotification;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class EventMonitor {

	@Resource
	private EventCalendar eventCalendar;
	@Resource
	private EventNotificationProcessor eventNotificationProcessor;

	public void checkEvents() {
		
		List<EventNotification> eventNotifications = eventCalendar
				.collectEventNotifications();
		
		for (EventNotification eventNotification : eventNotifications) {
			eventNotificationProcessor.process(eventNotification);
		}
	}

}
