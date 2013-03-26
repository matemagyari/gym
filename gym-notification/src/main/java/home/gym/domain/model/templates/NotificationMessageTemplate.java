package home.gym.domain.model.templates;

import home.gym.calendar.api.model.event.EventNotification;
import home.gym.calendar.api.model.event.EventNotificationType;
import home.gym.domain.model.MessageText;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class NotificationMessageTemplate {

    private static final String FIRST_NAME_PLACEHOLDER = "\\{firstName\\}";
    private static final String LOCATION_PLACEHOLDER = "\\{location\\}";
    private static final String DATETIME_PLACEHOLDER = "\\{datetime\\}";
    private static DateTimeFormatter formatter =  DateTimeFormat.forPattern("dd.MM.yyy HH:mm");

    private final EventNotificationType eventType;
    private final String messageTextTemplate;

    public NotificationMessageTemplate(EventNotificationType eventType, String messageText) {
        this.eventType = eventType;
        this.messageTextTemplate = messageText;
    }

    public MessageText generateMessageText(EventNotification eventNotification) {

        if (!eventNotification.getType().equals(getEventType())) {
            throw new RuntimeException();
        }

        String text = resolvePlaceholders(eventNotification);
        return new MessageText(text);
    }

    private String resolvePlaceholders(EventNotification eventNotification) {

        String printableDate = formatter.print(eventNotification.getDateTime());

        return messageTextTemplate
                   .replaceAll(NotificationMessageTemplate.FIRST_NAME_PLACEHOLDER, eventNotification.getMember().getFirstName())
                   .replaceAll(NotificationMessageTemplate.DATETIME_PLACEHOLDER, printableDate)
                   .replaceAll(NotificationMessageTemplate.LOCATION_PLACEHOLDER, eventNotification.getLocation().textFormat());
    }

    public EventNotificationType getEventType() {
        return eventType;
    }

}
