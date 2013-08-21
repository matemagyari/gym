package home.gym.domain.core.service;

import home.gym.calendar.api.model.event.EventNotification;
import home.gym.calendar.api.service.EventCalendar;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

@Named
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
