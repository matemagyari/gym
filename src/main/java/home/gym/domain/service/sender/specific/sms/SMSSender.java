package home.gym.domain.service.sender.specific.sms;

import home.gym.domain.model.MessageText;
import home.gym.domain.model.core.contact.PhoneNumber;
import home.gym.domain.service.sender.core.ContactTypeSpecificSender;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class SMSSender implements ContactTypeSpecificSender<PhoneNumber> {

	@Resource 
	private SMSSenderAdapter smsSenderAdapter;

	@Override
	public void send(PhoneNumber phoneNumber, MessageText message) {
		smsSenderAdapter.send(phoneNumber.textValue(), message.toString());
	}
	
	
	@Override
	public Class<PhoneNumber> getContactType() {
		return PhoneNumber.class;
	}


}
