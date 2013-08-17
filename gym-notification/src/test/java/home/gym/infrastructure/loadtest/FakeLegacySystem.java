package home.gym.infrastructure.loadtest;

import home.gym.calendar.api.model.event.EventNotification;
import home.gym.calendar.api.service.EventCalendar;

import java.util.List;

public class FakeLegacySystem implements EventCalendar {

    private  List<EventNotification> notifications;

    @Override
    public List<EventNotification> collectEventNotifications() {
        return this.notifications;
    }
    
    public void setNotifications(List<EventNotification> notifications) {
        this.notifications = notifications;
    }

}
