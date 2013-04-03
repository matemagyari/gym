package home.gym.infrastructure.persistence.repository;

import home.gym.domain.model.templates.NotificationMessageTemplate;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class XlsBasedNotificationTemplateStore implements NotificationTemplateStore {

    @Override
    public List<NotificationMessageTemplate> readAll() {
      return Lists.newArrayList();
    }

}
