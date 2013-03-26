package home.gym.calendar.api.model.core.member;


public class MemberName {

	private String firstName;

	private MemberName() {
	}

	public static MemberName createWithFirstName(String firstName) {
		MemberName memberName = new MemberName();
		memberName.firstName = firstName;
		return memberName ;
	}
	
	public String getFirstName() {
		return firstName;
	}


    
    

}
