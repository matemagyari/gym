package home.gym.domain.service.sender.specific.email;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailMessage other = (EmailMessage) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmailMessage [subject=" + subject + ", body=" + body + ", to="
				+ to + "]";
	}
	
}
