package home.gym.integration.test.dataobjects;

public class NotificationTemplateDO {

    private String eventNotificationType;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEventNotificationType() {
        return eventNotificationType;
    }

    public void setEventNotificationType(String eventType) {
        this.eventNotificationType = eventType;
    }

}
