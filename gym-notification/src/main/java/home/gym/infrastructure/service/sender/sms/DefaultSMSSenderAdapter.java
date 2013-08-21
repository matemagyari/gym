package home.gym.infrastructure.service.sender.sms;

import home.gym.domain.sms.service.SMSSenderAdapter;

import javax.inject.Named;

@Named
public class DefaultSMSSenderAdapter implements SMSSenderAdapter {

	@Override
	public void send(String phoneNumber, String text) {
	}

}
