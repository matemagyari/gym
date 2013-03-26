package home.gym.infrastructure.service.sender.sms;

import org.springframework.stereotype.Component;

import home.gym.domain.service.sender.specific.sms.SMSSenderAdapter;

@Component
public class DefaultSMSSenderAdapter implements SMSSenderAdapter {

	@Override
	public void send(String phoneNumber, String text) {
	}

}
