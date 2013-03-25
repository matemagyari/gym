package home.gym.domain.model.event;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EventNotificationType {
	
	private String id;

	public EventNotificationType(String id) {
		this.id = id;
	}

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EventNotificationType)) {
            return false;
        }
        EventNotificationType castOther = (EventNotificationType) other;
        return new EqualsBuilder().append(id, castOther.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(id).hashCode();
    }
	
	
	
}
