package home.gym.domain.model.templates;

import static org.junit.Assert.assertEquals;
import home.gym.domain.model.MessageText;
import home.gym.domain.model.core.member.Member;
import home.gym.domain.model.core.member.MemberName;
import home.gym.domain.model.event.EventNotification;
import home.gym.domain.model.event.EventNotificationType;
import home.gym.domain.model.event.Location;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class NotificationMessageTemplateTest {
	
	NotificationMessageTemplate testObj;
	EventNotificationType eventType = new EventNotificationType("12");
    EventNotification eventNotification;

	@Before
	public void setup() {
	    MemberName name = MemberName.createWithFirstName("Kata") ;
        Member member = new Member(name, null);
        Location location = new Location("W12 Q34");
        DateTime dateTime = new DateTime();
        eventNotification = new EventNotification(eventType, member, location, dateTime);
	}
	
	@Test
	public void generateMessageText() {
		//setup
		String messageText = "Dear {firstName}, your induction is due {datetime} at {location}.";
		testObj = new NotificationMessageTemplate(eventType, messageText );
		
		//act
		MessageText result = testObj.generateMessageText(eventNotification);
		//assert
		assertEquals("Dear Kata, your induction is due 17.06.2013 09:30 at W12 Q34.", result.toString());
		
	}

}
