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
public class KitadelUserBasicSteps extends ScenarioSteps {

    @Autowired
    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    ForgotPasswordPage forgotPasswordPage;
    SignUpPage signUpPage;

    @Autowired
    WebProperties webProperties;


    @Given("^user is on landing page$")
    public void userIsOnLandingPage(){
        // Write code here that turns the phrase above into concrete actions
        landingPage.openAt(webProperties.endpoint("landingpage"));
    }

    @When("^user clicked on sign in button$")
    public void userClickedOnSignInButton(){
        // Write code here that turns the phrase above into concrete actions
        landingPage.clickButtonLogin();
    }

    @And("^user input \"([^\"]*)\" to email box$")
    public void userInputToEmailBox(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.insertEmail(arg0);

    }

    @And("^user input \"([^\"]*)\" to password box$")
    public void userInputToPasswordBox(String arg0){
        // Write code here that turns the phrase above into concrete actions
        loginPage.insertPassword(arg0);
    }

    @And("^user clicked log in$")
    public void userClickedLogIn(){
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickButtonLogin();
    }

    @And("^user clicked skip$")
    public void userClickedSkip(){
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickButtonSkip();
    }

    @Then("^user can see portfolio value")
    public void userCanSeePortfolioValue(){
        assertThat("portfolio loaded",
            homePage.isPortfolioValueVisible(),
            equalTo(true));
    }

    @Then("^user is on homepage$")
    public void userIsOnHomepage(){
        // Write code here that turns the phrase above into concrete actions
        forgotPasswordPage.waitForTitleToDisappear("Kitadel");
        assertThat("is not in home page",
                homePage.getTitle().toLowerCase(),
                containsString("dashboard"));
    }

    @And("^user is not on homepage$")
    public void userIsNotOnHomepage()  {
        // Write code here that turns the phrase above into concrete actions
        assertThat("is not in home page",
                homePage.getTitle().toLowerCase(),
                not(containsString("dashboard")));
    }

    @And("^user clicked on forget password$")
    public void userClickedOnForgetPassword(){
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickButtonForgetPassword();
    }

    @Then("^user is on forget password page$")
    public void userIsOnForgetPasswordPage(){
        // Write code here that turns the phrase above into concrete actions
        forgotPasswordPage.waitForTitleToDisappear("Kitadel");
        assertThat("is not directed correctly",
                forgotPasswordPage.getTitle().toLowerCase(),
                containsString("reset"));
    }

    @When("^user type \"([^\"]*)\" on forget email input$")
    public void userTypeEmailOnForgetEmailInput(String arg0){
        // Write code here that turns the phrase above into concrete actions
        forgotPasswordPage.insertEmail(arg0);
    }

    @And("^user click on send instructions$")
    public void userClickOnSendInstructions(){
        // Write code here that turns the phrase above into concrete actions
        forgotPasswordPage.clickButtonSendInstruction();
    }

    @Then("^user can see instruction is sent$")
    public void userCanSeeInstructionIsSent(){
        // Write code here that turns the phrase above into concrete actions
        assertThat("banner not visible",
                forgotPasswordPage.bannerInstructionSentIsVisible(),
                equalTo(true));
    }


    @When("^user clicked on sign up button$")
    public void userClickedOnSignUpButton() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.clickButtonSignUp();
    }

    @Then("^user should be on sign up page$")
    public void userShouldBeOnSignUpPage() {
        // Write code here that turns the phrase above into concrete actions
        signUpPage.waitForTitleToDisappear("Kitadel");
        assertThat("not in sign up page",
                signUpPage.getTitle().toLowerCase(),
                containsString("sign up"));
    }

    @When("^user input \"([^\"]*)\" to new email input$")
    public void userInputToNewEmailInput(String arg0) {
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^user input \"([^\"]*)\" to new first name input$")
    public void userInputToNewFirstNameInput(String arg0) {
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^user input \"([^\"]*)\" to new last name input$")
    public void userInputToNewLastNameInput(String arg0) {
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^user input \"([^\"]*)\" to new password input$")
    public void userInputToNewPasswordInput(String arg0) {
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^user re - input \"([^\"]*)\" to new retype password input$")
    public void userReInputToNewRetypePasswordInput(String arg0) {
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^user click create account$")
    public void userClickCreateAccount() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user is on second sign up page$")
    public void userIsOnSecondSignUpPage() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user is on sign in page$")
    public void userIsOnSignInPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.waitForTitleToDisappear("Kitadel");
        assertThat("salah page",
                loginPage.getTitle().toLowerCase(),
                containsString("login"));
    }

    @And("^user clicked on log into your account button$")
    public void userClickedOnLogIntoYourAccountButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        signUpPage.clickButtonLogin();
    }

}