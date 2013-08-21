package home.gym.integration.test.stubdependencies;

import home.gym.domain.sms.service.SMSSenderAdapter;
import home.gym.integration.test.dataobjects.SMSMessageDO;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

public class FakeSMSSenderAdapter implements SMSSenderAdapter {

	private List<SMSMessageDO> sentSMSs = new ArrayList<SMSMessageDO>();

	@Override
	public void send(String phoneNumber, String text) {
		sentSMSs.add(new SMSMessageDO(phoneNumber, text));
	}
	
	public void verifySMSWasSent(SMSMessageDO sms) {
		if (!sentSMSs.contains(sms)) {
			Assert.fail();
		}
	}

	public void reset() {
		sentSMSs.clear();
	}

}
