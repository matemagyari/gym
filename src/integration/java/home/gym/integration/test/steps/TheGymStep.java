package home.gym.integration.test.steps;

import home.gym.integration.test.steps.dataobjects.EmailMessageDO;
import home.gym.integration.test.steps.dataobjects.EventDO;
import home.gym.integration.test.steps.dataobjects.MemberDO;
import home.gym.integration.test.steps.dataobjects.SMSMessageDO;

import java.util.List;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

//hello
//master comment
//comment
public class TheGymStep {

    @Given("^members in system$")
    public void members_in_system(List<MemberDO> members) {
        // Express the Regexp above with the code you wish you had
    }
    
    @When("^Information System read is fired and the following events occured$")
    public void Information_System_read_is_fired_and_the_following_events_occured(List<EventDO> events) {
        // Express the Regexp above with the code you wish you had
    }
    
    @Then("^email sent$")
    public void email_sent(List<EmailMessageDO> dos) {
        // Express the Regexp above with the code you wish you had
    }
    @Then("^sms sent$")
    public void sms_sent(List<SMSMessageDO> dos) {
        // Express the Regexp above with the code you wish you had
    }
}
