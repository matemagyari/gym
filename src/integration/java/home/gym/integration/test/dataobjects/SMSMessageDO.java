package home.gym.integration.test.dataobjects;

public class SMSMessageDO {

    private String telephoneNumber;
    private String textContains;
    
    public SMSMessageDO(String telephoneNumber, String textContains) {
		this.telephoneNumber = telephoneNumber;
		this.textContains = textContains;
	}

	public SMSMessageDO() {
	}

	public String getTextContains() {
        return textContains;
    }

    public void setTextContains(String textContains) {
        this.textContains = textContains;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

}
