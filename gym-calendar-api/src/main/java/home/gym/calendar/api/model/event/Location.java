package home.gym.calendar.api.model.event;

public class Location {

	private String location;

	public Location(String location) {
		this.location = location;
	}

	public String textFormat() {
		return location;
	}

}
