package home.gym.infrastructure.persistence.repository;

import home.gym.domain.core.model.NotificationMessageTemplate;

import java.util.List;

import javax.inject.Named;

import com.google.common.collect.Lists;

@Named
public class XlsBasedNotificationTemplateStore implements NotificationTemplateStore {

    @Override
    public List<NotificationMessageTemplate> readAll() {
      return Lists.newArrayList();
    }

}
