package home.gym.domain.model;

import home.gym.domain.model.event.EventNotificationType;
import home.gym.domain.model.templates.NotificationMessageTemplate;

import java.util.List;

public interface NotificationMessageTemplateRepository {

	void store(List<NotificationMessageTemplate> notificationTemplates);

	NotificationMessageTemplate find(EventNotificationType eventType);

}
