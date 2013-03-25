package home.gym.domain.model.templates;

import home.gym.domain.model.MessageText;
import home.gym.domain.model.event.EventNotification;
import home.gym.domain.model.event.EventNotificationType;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class NotificationMessageTemplate {

    private static final String FIRST_NAME_PLACEHOLDER = "\\{firstName\\}";
    private static final String LOCATION_PLACEHOLDER = "\\{location\\}";
    private static final String DATETIME_PLACEHOLDER = "\\{datetime\\}";
    private static final DateTimeFormatter formatter = ISODateTimeFormat.dateHourMinute();

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

        String text = messageTextTemplate;

        String printableDate = formatter.print(eventNotification.getDateTime());

        // text.replaceAll(NotificationMessageTemplate.FIRST_NAME_PLACEHOLDER,
        // eventNotification.getMember().getFirstName())
        // .replaceAll(NotificationMessageTemplate.LOCATION_PLACEHOLDER,
        // eventNotification.getLocation().textFormat())
        // .replaceAll(NotificationMessageTemplate.DATETIME_PLACEHOLDER,
        // printableDate);
        text = text.replaceAll(NotificationMessageTemplate.FIRST_NAME_PLACEHOLDER, eventNotification.getMember().getFirstName());
        text = text.replaceAll(NotificationMessageTemplate.DATETIME_PLACEHOLDER, printableDate);
        text = text.replaceAll(NotificationMessageTemplate.LOCATION_PLACEHOLDER, eventNotification.getLocation().textFormat());
        return text;
    }

    public EventNotificationType getEventType() {
        return eventType;
    }

}
