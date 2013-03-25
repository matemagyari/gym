package home.gym.integration.test.stubdependencies;

import java.util.List;

import home.gym.domain.model.event.EventNotification;
import home.gym.domain.service.EventCalendar;

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
