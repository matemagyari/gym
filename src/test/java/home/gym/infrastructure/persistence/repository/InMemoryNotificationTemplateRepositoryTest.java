package home.gym.infrastructure.persistence.repository;

import static org.junit.Assert.assertEquals;
import home.gym.domain.model.event.EventNotificationType;
import home.gym.domain.model.templates.NotificationMessageTemplate;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

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

	private void assertMatches(NotificationMessageTemplate expected,
			NotificationMessageTemplate actual) {

		assertEquals(expected.getEventType(), actual.getEventType());

	}

}
