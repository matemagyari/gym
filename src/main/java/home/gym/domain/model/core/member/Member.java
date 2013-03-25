package home.gym.domain.model.core.member;

import home.gym.domain.model.core.contact.Contacts;

public class Member {

	private final MemberName name;
	private final Contacts contacts;

	public Member(MemberName name, Contacts contacts) {
		this.name = name;
		this.contacts = contacts;
	}

	public Contacts contacts() {
		return contacts;
	}

	public String getFirstName() {
		return name.getFirstName();
	}

}
