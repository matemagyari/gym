package home.gym.integration.test.scan;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features={"src/test/resources/features/notification_templates_available_by_startup.feature"}
				 ,glue    ={"home.gym.integration.test.stepdefinitions"})

public class NotificationTemplatesAvailableByStartupITest {

}
