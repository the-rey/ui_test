package com.gdn.qa.module.ui.training.steps;

import com.gdn.qa.automation.core.CucumberStepsDefinition;
import com.gdn.qa.automation.core.properties.WebProperties;
import com.gdn.qa.module.ui.training.pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by reynaldo.nathanael on 8/14/2018.
 */

@CucumberStepsDefinition
public class KitadelTradingSteps extends ScenarioSteps {

    @Autowired
    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    ForgotPasswordPage forgotPasswordPage;
    SignUpPage signUpPage;

    @Autowired
    WebProperties webProperties;

    @When("^user clicked on Marketplace Tab$")
    public void userClickedOnMarketplaceTab(){
        // Write code here that turns the phrase above into concrete actions
        homePage.clickTabMarketplace();
    }

    @Then("^user can see token sales$")
    public void userCanSeeTokenSales() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat("gak keliatan table nya",
            homePage.element(homePage.xpathPortfolioValue).isVisible(),
            equalTo(true));

    }

    @And("^user can see exchange coin pairs$")
    public void userCanSeeExchangeCoinPairs() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat("gak keliatan table nya",
                homePage.element(homePage.xpathPortfolioValue).isVisible(),
                equalTo(true));
    }

    @When("^user clicked on bitcoin/idr pair$")
    public void userClickedOnBitcoinIdrPair() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickBitcoinIdrPair();
    }

    @Then("^user is on bitcoin trading page$")
    public void userIsOnBitcoinTradingPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.waitForTitleToDisappear("Kitadel");
        assertThat("gak masuk",
                homePage.getTitle().toLowerCase(),
                containsString("bitcoin"));
    }
}
