package home.gym.infrastructure.persistence.repository;

import home.gym.calendar.api.model.event.EventNotificationType;
import home.gym.domain.model.NotificationMessageTemplateRepository;
import home.gym.domain.model.templates.NotificationMessageTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;

@Component
public class InMemoryNotificationTemplateRepository implements
		NotificationMessageTemplateRepository {
	
	private Map<EventNotificationType, NotificationMessageTemplate> map = new HashMap<EventNotificationType, NotificationMessageTemplate>();
	
	@Resource
	private NotificationTemplateStore notificationTemplateStore;
	
	@SuppressWarnings("unused")
    @PostConstruct
	private void populate() {
	    List< NotificationMessageTemplate> templates = notificationTemplateStore.readAll();
	    for (NotificationMessageTemplate template : templates) {
            map.put(template.getEventType(), template);
        }
	}

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

    @Override
    public Set<NotificationMessageTemplate> findAll() {
        return Sets.newHashSet(map.values());
    }

}
