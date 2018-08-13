package com.gdn.qa.module.ui.training.steps;


import com.gdn.qa.automation.core.CucumberStepsDefinition;
import com.gdn.qa.module.ui.training.api.services.BadakController;
import com.gdn.qa.module.ui.training.data.BadakData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@CucumberStepsDefinition
public class BadakSteps extends ScenarioSteps {

  @Autowired
  BadakController badakController;

  @Autowired
  BadakData badakData;

  @Given("^\\[badak-app] prepare get project request data$")
  public void badakAppPrepareGetProjectRequestData() throws Throwable {

  }

  @When("^\\[badak-app] send get project request$")
  public void badakAppSendGetProjectRequest() throws Throwable {
    badakData.setProjectResponse(badakController.getProject());
  }

  @Then("^\\[badak-app] the schema should be same$")
  public void badakAppTheSchemaShouldBeSame() throws Throwable {
    String response = badakData.getProjectResponse().getResponse().getBody().asString();
    assertThat("json structure is not same with the schema",response,matchesJsonSchemaInClasspath("schemas/schema.json"));
  }

  @And("^\\[badak-app] response time must be less than '(\\d+)' '(.*)'")
  public void badakAppResponseTimeMustBeLessThanSeconds(Long seconds, TimeUnit timeUnit) throws Throwable {
    Long time = badakData.getProjectResponse().getResponse().getTimeIn(timeUnit);
    System.out.println("time:"+time);
    assertThat(String.format("Response Time is More than %d seconds",seconds),time,lessThanOrEqualTo(seconds));
  }
}
