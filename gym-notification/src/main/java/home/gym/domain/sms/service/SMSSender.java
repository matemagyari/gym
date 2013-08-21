package home.gym.domain.sms.service;

import home.gym.calendar.api.model.core.contact.PhoneNumber;
import home.gym.domain.core.model.MessageText;
import home.gym.domain.core.service.sender.core.ContactTypeSpecificSender;

import javax.annotation.Resource;
import javax.inject.Named;

@Named
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
