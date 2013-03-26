package home.gym.calendar.api.model.core.contact;


public class EmailAddress implements Contact {

	private final String emailAddress;

	public EmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String textValue() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "EmailAddress [emailAddress=" + emailAddress + "]";
	}
	
}
