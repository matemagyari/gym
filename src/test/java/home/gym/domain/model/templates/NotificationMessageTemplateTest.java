package home.gym.domain.model.templates;

import home.gym.domain.model.event.EventNotificationType;

import org.junit.Before;
import org.junit.Test;

public class NotificationMessageTemplateTest {
	
	NotificationMessageTemplate testObj;
	EventNotificationType eventType = new EventNotificationType("12");

	@Before
	public void setup() {
		
	}
	
	@Test
	public void test() {
		
		String messageText = "";
		testObj = new NotificationMessageTemplate(eventType, messageText );
		
	}

}
