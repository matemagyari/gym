package home.gym.integration.test.stubdependencies;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import home.gym.domain.email.model.EmailMessage;
import home.gym.domain.email.service.EmailSenderAdapter;

public class FakeEmailSenderAdapter implements EmailSenderAdapter {
	
	private List<EmailMessage> sentMessages = new ArrayList<EmailMessage>();

	@Override
	public void send(EmailMessage emailMessage) {
		sentMessages.add(emailMessage);
	}

	public void verifyEmailWasSent(EmailMessage emailMessage) {
		if (!sentMessages.contains(emailMessage)) {
			Assert.fail();
		}
	}
	
	public void reset() {
		sentMessages.clear();
	}

}
