package home.gym.integration.test.util;

import home.gym.calendar.api.model.core.contact.Contacts;
import home.gym.calendar.api.model.core.contact.EmailAddress;
import home.gym.calendar.api.model.core.contact.PhoneNumber;
import home.gym.calendar.api.model.core.member.Member;
import home.gym.calendar.api.model.core.member.MemberName;
import home.gym.calendar.api.model.event.EventNotification;
import home.gym.calendar.api.model.event.EventNotificationType;
import home.gym.calendar.api.model.event.Location;
import home.gym.domain.model.templates.NotificationMessageTemplate;
import home.gym.domain.service.sender.specific.email.EmailMessage;
import home.gym.integration.test.dataobjects.EmailMessageDO;
import home.gym.integration.test.dataobjects.EventNotificationDO;
import home.gym.integration.test.dataobjects.MemberDO;
import home.gym.integration.test.dataobjects.NotificationTemplateDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TransformerUtil {
    
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyy HH:mm");

	public static List<NotificationMessageTemplate> transform(
			List<NotificationTemplateDO> notificationTemplateDOs) {
		
		List<NotificationMessageTemplate> templates = new ArrayList<NotificationMessageTemplate>();
		for (NotificationTemplateDO notificationTemplateDO : notificationTemplateDOs) {
			templates.add(transform(notificationTemplateDO));
		}
		
		return templates ;
	}
	
	private static NotificationMessageTemplate transform(NotificationTemplateDO templateDO) {
		
		EventNotificationType eventType = new EventNotificationType(templateDO.getEventNotificationType());
		return new NotificationMessageTemplate(eventType , templateDO.getText());
		
	}

	public static List<Member> transformMemberDOS(List<MemberDO> memberDOs) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Member transform(MemberDO memberDO) {
		MemberName name = MemberName.createWithFirstName(memberDO.getName());
		PhoneNumber phoneNumber = new PhoneNumber(memberDO.getTelephoneNumber());
		EmailAddress emailAddress = new EmailAddress(memberDO.getEmailAddress());
		Contacts contacts = new Contacts(phoneNumber,emailAddress);
		return new Member(name , contacts);
	}

	public static List<EventNotification> transformEventNotifications(
			List<EventNotificationDO> events, Map<Long, Member> memberStore) {
		
		List<EventNotification> notifications = new ArrayList<EventNotification>();
		for (EventNotificationDO notificationDO : events) {
			notifications.add(transform(notificationDO, memberStore));
		}
		
		return notifications ;
	}

	private static EventNotification transform(
			EventNotificationDO notificationDO, Map<Long, Member> memberStore) {

		
		EventNotificationType type = new EventNotificationType(notificationDO.getEventNotificationType());
		Member member = memberStore.get(notificationDO.getMember());
		Location location = new Location(notificationDO.getLocation());
		DateTime dateTime = formatter.parseDateTime(notificationDO.getTime());
		return new EventNotification(type, member, location, dateTime);
	}

	public static EmailMessage transform(EmailMessageDO emailMessageDO) {
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setTo(emailMessageDO.getEmailAddress());
		emailMessage.setBody(emailMessageDO.getTextContains());
        emailMessage.setSubject(emailMessageDO.getSubject());
		return emailMessage;
	}

}
