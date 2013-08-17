package home.gym.domain.service;

import home.gym.calendar.api.model.core.contact.Contacts;
import home.gym.calendar.api.model.core.contact.PhoneNumber;
import home.gym.calendar.api.model.core.member.Member;
import home.gym.calendar.api.model.core.member.MemberName;
import home.gym.calendar.api.model.event.EventNotification;
import home.gym.calendar.api.model.event.EventNotificationType;
import home.gym.calendar.api.model.event.Location;
import home.gym.domain.model.NotificationMessageTemplateRepository;
import home.gym.domain.model.templates.NotificationMessageTemplate;
import home.gym.infrastructure.loadtest.DelayingFakeSMSSenderAdapter;
import home.gym.infrastructure.loadtest.FakeLegacySystem;

import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.google.common.collect.Lists;

@ContextConfiguration(locations = "classpath:/META-INF/applicationContext-gym-load-test.xml")
public class EventMonitorLoadTest extends AbstractJUnit4SpringContextTests {

    private static final EventNotificationType notificationType = new EventNotificationType("INDUCTION_DUE");

    @Resource
    private EventMonitor eventMonitor;
    @Resource
    private FakeLegacySystem eventCalendar;
    @Resource
    private DelayingFakeSMSSenderAdapter smsSenderAdapter;
    @Resource
    private NotificationMessageTemplateRepository notificationMessageTemplateRepository;

    @Test//(timeout=5000)
    public void loadTest() {

        // setup
        smsSenderAdapter.setDelayInMilisec(1000);
        List<EventNotification> notifications = notifications(1000);
        eventCalendar.setNotifications(notifications);
        NotificationMessageTemplate template = new NotificationMessageTemplate(notificationType, "{firstName} x {location}");
        notificationMessageTemplateRepository.store(Lists.newArrayList(template));

        // act
        long start = System.currentTimeMillis();
        eventMonitor.checkEvents();
        

        while (smsSenderAdapter.getSentMessagesNumber() < notifications.size()-1) {
            sleep(100);
        }
        long end = System.currentTimeMillis();
        System.out.println("last smsSenderAdapter.getSentMessagesNumber() " + smsSenderAdapter.getSentMessagesNumber());
        long timeElapsed = end - start;
        System.out.println("Time elapsed: " + timeElapsed);
    }


    private List<EventNotification> notifications(int number) {
        List<EventNotification> list = Lists.newArrayList();

        
        Location location = new Location("435457y567");

        for (int i = 0; i < number; i++) {
            Member member = new Member(MemberName.createWithFirstName("xxx"), new Contacts(new PhoneNumber("0"+i)));
            list.add(new EventNotification(notificationType, member, location, new DateTime()));
        }

        return list;
    }
    

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
