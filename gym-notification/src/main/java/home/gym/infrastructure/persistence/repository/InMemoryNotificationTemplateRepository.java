package home.gym.infrastructure.persistence.repository;

import home.gym.calendar.api.model.event.EventNotificationType;
import home.gym.domain.model.NotificationMessageTemplateRepository;
import home.gym.domain.model.templates.NotificationMessageTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class InMemoryNotificationTemplateRepository implements
		NotificationMessageTemplateRepository {
	
	private Map<EventNotificationType, NotificationMessageTemplate> map = new HashMap<EventNotificationType, NotificationMessageTemplate>();

	@Override
	public void store(List<NotificationMessageTemplate> notificationTemplates) {
		for (NotificationMessageTemplate template : notificationTemplates) {
			map.put(template.getEventType(), template);
		}
		
	}
	
	@Override
	public NotificationMessageTemplate find(EventNotificationType eventType) {
		return map.get(eventType);
	}

}
