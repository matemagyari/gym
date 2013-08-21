package home.gym.domain.core.service;

import home.gym.calendar.api.model.event.EventNotification;
import home.gym.domain.core.model.MessageDestination;
import home.gym.domain.core.model.MessageText;
import home.gym.domain.core.model.NotificationMessage;
import home.gym.domain.core.model.NotificationMessageTemplateRepository;
import home.gym.domain.core.model.templates.NotificationMessageTemplate;

import javax.annotation.Resource;
import javax.inject.Named;

@Named
public class NotificationMessageBuilder {

    @Resource
    private NotificationMessageTemplateRepository notificationMessageTemplateRepository;

    public NotificationMessage build(EventNotification eventNotification) {

        NotificationMessageTemplate messageTemplate = notificationMessageTemplateRepository.find(eventNotification.getType());

        MessageText messageText = messageTemplate.generateMessageText(eventNotification);

        MessageDestination destination = new MessageDestination(eventNotification.getMemberContacts());

        return new NotificationMessage(destination, messageText);
    }

}
