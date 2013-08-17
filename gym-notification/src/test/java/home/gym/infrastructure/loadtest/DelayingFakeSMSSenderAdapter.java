package home.gym.infrastructure.loadtest;

import home.gym.domain.service.sender.specific.sms.SMSSenderAdapter;

import java.util.List;

import com.google.common.collect.Lists;

public class DelayingFakeSMSSenderAdapter implements SMSSenderAdapter {

    private long delayInMilisec;
    private List<String> sentMessages = Lists.newArrayList();

    @Override
    public void send(String phoneNumber, String text) {

        sleep();
        sentMessages.add(phoneNumber);
        System.err.println((sentMessages.size()) + ". message is sent to "+phoneNumber);
    }

    public void setDelayInMilisec(long delayInMilisec) {
        this.delayInMilisec = delayInMilisec;
    }
    
    public List<String> getSentMessages() {
        return sentMessages;
    }
    
    
    public int getSentMessagesNumber() {
        return sentMessages.size();
    }
    
    private void sleep() {
        try {
            Thread.sleep(delayInMilisec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
