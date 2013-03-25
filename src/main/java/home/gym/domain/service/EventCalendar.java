package home.gym.domain.service;

import home.gym.domain.model.event.EventNotification;

import java.util.List;

public interface EventCalendar {
    
    List<EventNotification> collectEventNotifications();

}
