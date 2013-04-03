package home.gym.infrastructure.persistence.repository;

import home.gym.domain.model.templates.NotificationMessageTemplate;

import java.util.List;

public interface NotificationTemplateStore {

    List<NotificationMessageTemplate> readAll();

}
