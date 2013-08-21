package home.gym.domain.sms.service;

public interface SMSSenderAdapter {

	void send(String phoneNumber, String text);

}
