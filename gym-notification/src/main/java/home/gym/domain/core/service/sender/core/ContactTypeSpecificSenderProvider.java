package home.gym.domain.core.service.sender.core;

import home.gym.calendar.api.model.core.contact.Contact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Named;

@Named
public class ContactTypeSpecificSenderProvider {
	
	private  Map<Class<? extends Contact>, ContactTypeSpecificSender<? extends Contact>> contactTypeSpecificSenders;
	
	@Resource
	public void setContactTypeSpecificSenders(
			List<ContactTypeSpecificSender<? extends Contact>> contactTypeSpecificSenders) {
		
		this.contactTypeSpecificSenders = new HashMap<Class<? extends Contact>, ContactTypeSpecificSender<? extends Contact>>();
		for (ContactTypeSpecificSender<? extends Contact> sender : contactTypeSpecificSenders) {
			this.contactTypeSpecificSenders.put(sender.getContactType(), sender);
		}
	}

	public <T extends Contact> ContactTypeSpecificSender<? extends Contact> getSender(Class<T> clazz) {
		return contactTypeSpecificSenders.get(clazz);
	}

}
