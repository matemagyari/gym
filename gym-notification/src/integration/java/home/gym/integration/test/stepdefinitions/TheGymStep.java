package home.gym.integration.test.stepdefinitions;

import static org.junit.Assert.assertFalse;
import home.gym.calendar.api.model.core.member.Member;
import home.gym.calendar.api.model.event.EventNotification;
import home.gym.domain.core.model.NotificationMessageTemplate;
import home.gym.domain.core.model.NotificationMessageTemplateRepository;
import home.gym.domain.core.service.EventMonitor;
import home.gym.domain.email.model.EmailMessage;
import home.gym.integration.test.dataobjects.EmailMessageDO;
import home.gym.integration.test.dataobjects.EventNotificationDO;
import home.gym.integration.test.dataobjects.MemberDO;
import home.gym.integration.test.dataobjects.NotificationTemplateDO;
import home.gym.integration.test.dataobjects.SMSMessageDO;
import home.gym.integration.test.stubdependencies.FakeEmailSenderAdapter;
import home.gym.integration.test.stubdependencies.FakeLegacySystem;
import home.gym.integration.test.stubdependencies.FakeSMSSenderAdapter;
import home.gym.integration.test.util.CucumberService;
import home.gym.integration.test.util.TransformerUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TheGymStep {

	private Map<Long, Member> memberStore;

	private NotificationMessageTemplateRepository notificationTemplateRepository;
	private EventMonitor eventMonitor;
	private FakeLegacySystem fakeLegacySystem;
	private FakeEmailSenderAdapter fakeEmailSenderAdapter;
	private FakeSMSSenderAdapter fakeSMSSenderAdapter;

	public TheGymStep() {
		initDependencies();
	}

	private void initDependencies() {
		notificationTemplateRepository = CucumberService
				.getBean(NotificationMessageTemplateRepository.class);
		eventMonitor = CucumberService.getBean(EventMonitor.class);

		fakeLegacySystem = CucumberService.getBean(FakeLegacySystem.class);
		fakeEmailSenderAdapter = CucumberService.getBean(FakeEmailSenderAdapter.class);
		fakeSMSSenderAdapter = CucumberService.getBean(FakeSMSSenderAdapter.class);
		memberStore = new HashMap<Long, Member>();
	}

	@Given("^members in system$")
	public void members_in_system(List<MemberDO> memberDOs) {
		for (MemberDO memberDO : memberDOs) {
			Member member = TransformerUtil.transform(memberDO);
			memberStore.put(memberDO.id, member);
		}
	}

	@Given("^notification message templates are$")
	public void notification_templates_are(
			List<NotificationTemplateDO> notificationTemplateDOs) {

		List<NotificationMessageTemplate> notificationTemplates = TransformerUtil
				.transform(notificationTemplateDOs);
		notificationTemplateRepository.store(notificationTemplates);
	}

	@When("^Information System read is fired and the following events occured$")
	public void Information_System_read_is_fired_and_the_following_events_occured(
			List<EventNotificationDO> events) {

		eventMonitor.checkEvents();
	}

	@Given("^the following event notifications are needed$")
	public void the_following_event_notifications_are_needed(
			List<EventNotificationDO> events) {
		
		List<EventNotification> eventNotifications = TransformerUtil.transformEventNotifications(events, memberStore);
		fakeLegacySystem.setup(eventNotifications);
	}

	@When("^monitoring is scheduled$")
	public void monitoring_is_scheduled() {
		eventMonitor.checkEvents();
	}

	@Then("^email sent$")
	public void email_sent(List<EmailMessageDO> dos) {
		for (EmailMessageDO emailMessageDO : dos) {
			EmailMessage emailMessage = TransformerUtil.transform(emailMessageDO);
			fakeEmailSenderAdapter.verifyEmailWasSent(emailMessage);
		}
	}

	@Then("^sms sent$")
	public void sms_sent(List<SMSMessageDO> dos) {
		for (SMSMessageDO smsMessageDO : dos) {
			fakeSMSSenderAdapter.verifySMSWasSent(smsMessageDO);
		}
	}
	
	@Then("^there are notification templates in the system$")
	public void there_are_notification_templates_in_the_system()  {
        Set<NotificationMessageTemplate> templates = notificationTemplateRepository.findAll();
        assertFalse(templates.isEmpty());
	}
}
