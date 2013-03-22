package home.gym.integration.test.steps.dataobjects;

public class MemberDO {

    private Long id;
    private String name;
    private String telephoneNumber;
    private String emailAddress;
    private String preferredNotificationMode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPreferredNotificationMode() {
        return preferredNotificationMode;
    }

    public void setPreferredNotificationMode(String preferredNotificationMode) {
        this.preferredNotificationMode = preferredNotificationMode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
