package home.gym.infrastructure.persistence.repository;

import home.gym.domain.core.model.NotificationMessageTemplate;

import java.util.List;

public interface NotificationTemplateStore {

    List<NotificationMessageTemplate> readAll();

}
