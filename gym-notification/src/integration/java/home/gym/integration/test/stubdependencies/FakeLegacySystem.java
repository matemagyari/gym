package home.gym.integration.test.stubdependencies;

import home.gym.calendar.api.model.event.EventNotification;
import home.gym.calendar.api.service.EventCalendar;

import java.util.List;

public class FakeLegacySystem implements EventCalendar {

	private List<EventNotification> eventNotifications;

	@Override
	public List<EventNotification> collectEventNotifications() {
		return eventNotifications;
	}

	public void setup(List<EventNotification> eventNotifications) {
		this.eventNotifications = eventNotifications;
	}

}
