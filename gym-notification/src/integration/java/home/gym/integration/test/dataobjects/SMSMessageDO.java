package home.gym.integration.test.dataobjects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SMSMessageDO {

    public String telephoneNumber;
    public String textContains;
    
    public SMSMessageDO(String telephoneNumber, String textContains) {
		this.telephoneNumber = telephoneNumber;
		this.textContains = textContains;
	}

	public SMSMessageDO() {
	}

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SMSMessageDO)) {
            return false;
        }
        SMSMessageDO castOther = (SMSMessageDO) other;
        return new EqualsBuilder().append(telephoneNumber, castOther.telephoneNumber).append(textContains, castOther.textContains).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(telephoneNumber).append(textContains).hashCode();
    }

    @Override
    public String toString() {
        return "SMSMessageDO [telephoneNumber=" + telephoneNumber + ", textContains=" + textContains + "]";
    }
}
