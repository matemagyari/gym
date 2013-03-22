package home.gym.integration.test.steps.dataobjects;

public class EventDO {

    private String eventType;
    private long member;
    private String location;
    private String time;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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
