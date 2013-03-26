package home.gym.integration.test.dataobjects;

public class EmailMessageDO {

    private String emailAddress;
    private String textContains;
    private String subject;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTextContains() {
        return textContains;
    }

    public void setTextContains(String textContains) {
        this.textContains = textContains;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
