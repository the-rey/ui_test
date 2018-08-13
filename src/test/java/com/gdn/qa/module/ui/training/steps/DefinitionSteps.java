package com.gdn.qa.module.ui.training.steps;

import com.gdn.qa.automation.core.properties.WebProperties;
import com.gdn.qa.automation.core.CucumberStepsDefinition;
import com.gdn.qa.module.ui.training.pages.DictionaryPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import net.thucydides.core.steps.ScenarioSteps;

@CucumberStepsDefinition
public class DefinitionSteps extends ScenarioSteps{

    @Autowired
    WebProperties webProperties;

    @Autowired
    DictionaryPage page;

    @Given("^the user is on the Wikionary home page$")
    public void theUserIsOnWikionaryHomePage() {
        page.openAt(webProperties.endpoint("wikionary"));
    }

    @When("^the user looks up the definition of the word '(.*)'$")
    public void theUserLooksUpTheDefinitionOfTheWordString(String word) {
        page.enter_keywords(word);
        page.lookup_terms();
    }

    @Then("^they should see the definition '(.*)'$")
    public void theyShouldSeeTheDefinitionString(String definition) {
        assertThat(page.getDefinitions(), hasItem(containsString(definition)));
    }


}
