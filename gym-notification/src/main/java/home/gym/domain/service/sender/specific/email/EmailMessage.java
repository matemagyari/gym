package home.gym.domain.service.sender.specific.email;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EmailMessage {

    private String subject;
    private String body;
    private String to;

    public void setTo(String to) {
        this.to = to;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EmailMessage)) {
            return false;
        }
        EmailMessage castOther = (EmailMessage) other;
        return new EqualsBuilder().append(subject, castOther.subject).append(body, castOther.body).append(to, castOther.to).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(subject).append(body).append(to).hashCode();
    }

    @Override
    public String toString() {
        return "EmailMessage [subject=" + subject + ", body=" + body + ", to=" + to + "]";
    }

}
