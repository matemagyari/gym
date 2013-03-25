package home.gym.domain.model.core.contact;

public class PhoneNumber implements Contact {

	private final String number;

	public PhoneNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [number=" + number + "]";
	}
	
	public String textValue() {
		return number;
	}
}
