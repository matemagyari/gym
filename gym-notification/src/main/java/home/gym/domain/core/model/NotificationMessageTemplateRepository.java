package home.gym.domain.core.model;

import home.gym.calendar.api.model.event.EventNotificationType;

import java.util.List;
import java.util.Set;

public interface NotificationMessageTemplateRepository {

	void store(List<NotificationMessageTemplate> notificationTemplates);

	NotificationMessageTemplate find(EventNotificationType eventType);
	
	//for test
	Set<NotificationMessageTemplate> findAll();

}
