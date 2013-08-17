package home.gym.infrastructure.persistence.repository;

import static org.junit.Assert.assertEquals;
import home.gym.calendar.api.model.event.EventNotificationType;
import home.gym.domain.model.templates.NotificationMessageTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class InMemoryNotificationTemplateRepositoryTest {

	InMemoryNotificationTemplateRepository testObj = new InMemoryNotificationTemplateRepository();

	NotificationMessageTemplate template1 = new NotificationMessageTemplate(
			new EventNotificationType("32"), "y");

	NotificationMessageTemplate template2 = new NotificationMessageTemplate(
			new EventNotificationType("46"), "fgfg");

	@Test
	public void storeAndFind() {
		// setup
		List<NotificationMessageTemplate> notificationTemplates = Arrays
				.asList(template1, template2);
		// act
		testObj.store(notificationTemplates);
		NotificationMessageTemplate foundTemplate1 = testObj.find(template1
				.getEventType());
		NotificationMessageTemplate foundTemplate2 = testObj.find(template2
				.getEventType());
		// assert
		assertMatches(foundTemplate1, template1);
		assertMatches(foundTemplate2, template2);
	}
	
	   @Test
	    public void storeAndFindAll() {
	        // setup
	        List<NotificationMessageTemplate> notificationTemplates = Arrays
	                .asList(template1, template2);
	        // act
	        testObj.store(notificationTemplates);
	        Set<NotificationMessageTemplate> foundTemplates = testObj.findAll();
	        // assert
	        assertEquals(Sets.newHashSet(template1, template2), foundTemplates);
	    }

	private void assertMatches(NotificationMessageTemplate expected,
			NotificationMessageTemplate actual) {

		assertEquals(expected.getEventType(), actual.getEventType());

	}

}
