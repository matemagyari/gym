package home.gym.calendar.api.service;

import home.gym.calendar.api.model.event.EventNotification;

import java.util.List;

public interface EventCalendar {
    
    List<EventNotification> collectEventNotifications();

}
