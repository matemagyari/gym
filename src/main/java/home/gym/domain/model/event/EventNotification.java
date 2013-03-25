package home.gym.domain.model.event;

import home.gym.domain.model.core.contact.Contacts;
import home.gym.domain.model.core.member.Member;

import org.joda.time.DateTime;

public class EventNotification {

	private final EventNotificationType type;
	private final Member member;
	private final Location location;
	private final DateTime dateTime;

	public EventNotification(EventNotificationType type, Member member,
			Location location, DateTime dateTime) {
		this.type = type;
		this.member = member;
		this.location = location;
		this.dateTime = dateTime;
	}

	public EventNotificationType getType() {
		return type;
	}

	public Member getMember() {
		return member;
	}

	public Location getLocation() {
		return location;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public Contacts getMemberContacts() {
		return member.contacts();
	}


}
