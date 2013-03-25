package home.gym.infrastructure.service;

import java.util.List;

import org.springframework.stereotype.Component;

import home.gym.domain.model.event.EventNotification;
import home.gym.domain.service.EventCalendar;

@Component
public class RemoteInformationSystemReader implements EventCalendar {

	@Override
	public List<EventNotification> collectEventNotifications() {
		// TODO Auto-generated method stub
		return null;
	}



}
