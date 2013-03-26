package home.gym.domain.service.sender.specific.sms;

public interface SMSSenderAdapter {

	void send(String phoneNumber, String text);

}
