package home.gym.integration.test.dataobjects;

public class EventNotificationDO {

    private String eventNotificationType;
    private long member;
    private String location;
    private String time;

    public String getEventNotificationType() {
        return eventNotificationType;
    }

    public void setEventNotificationType(String eventType) {
        this.eventNotificationType = eventType;
    }

    public long getMember() {
        return member;
    }

    public void setMember(long member) {
        this.member = member;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
