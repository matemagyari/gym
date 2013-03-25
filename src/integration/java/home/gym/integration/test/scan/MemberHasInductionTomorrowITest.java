package home.gym.integration.test.scan;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features={"src/test/resources/features/member_has_induction_tomorrow.feature"}
				 ,glue    ={"home.gym.integration.test.stepdefinitions"})

public class MemberHasInductionTomorrowITest {

}
