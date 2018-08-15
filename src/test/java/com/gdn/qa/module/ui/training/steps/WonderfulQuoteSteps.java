package com.gdn.qa.module.ui.training.steps;

import com.gdn.qa.automation.core.CucumberStepsDefinition;
import com.gdn.qa.automation.core.properties.WebProperties;
import com.gdn.qa.module.ui.training.pages.WonderfulQuotePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.springframework.beans.factory.annotation.Autowired;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

@CucumberStepsDefinition
public class WonderfulQuoteSteps extends ScenarioSteps {

    @Autowired
    WonderfulQuotePage wonderfulQuotePage;

    @Autowired
    WebProperties webProperties;

    @Given("^user open wonderful quotes page$")
    public void userOpenWonderfulQuotesPage(){
        // Write code here that turns the phrase above into concrete actions
        wonderfulQuotePage.openAt(webProperties.endpoint("wonderfulquotes"));
        //wonderfulQuotePage.openAt("http://gosoft.web.id/wonderfulQuote/");
    }

    @When("^user input \"([^\"]*)\" on quote field$")
    public void userInputOnQuoteField(String quote){
        // Write code here that turns the phrase above into concrete actions
        wonderfulQuotePage.inputTextQuote(quote);
    }

    @And("^user input \"([^\"]*)\" on author field$")
    public void userInputOnAuthorField(String author){
        // Write code here that turns the phrase above into concrete actions
        wonderfulQuotePage.inputTextAuthor(author);
    }

    @And("^user input \"([^\"]*)\" on background field$")
    public void userInputOnBackgroundField(String arg0){
        // Write code here that turns the phrase above into concrete actions
        wonderfulQuotePage.selectBackgroundColor(arg0);
    }

    @And("^user click on add quote$")
    public void userClickOnAddQuote(){
        // Write code here that turns the phrase above into concrete actions
        wonderfulQuotePage.clickButtonAddQuote();
    }

    @Then("^user should see \"([^\"]*)\" and author \"([^\"]*)\" on panel and background color is \"([^\"]*)\"$")
    public void userShouldSeeAndAuthorOnPanelAndBackgroundColorIs(String arg0, String arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        assertThat("Penambahan Quote Gagal, Quote Tidak ada",
                wonderfulQuotePage.getListOfQuotes(),
                hasItem(containsString(arg0))
        );
        assertThat("Penambahan Author gagal, Author tidak ada",
                wonderfulQuotePage.getListOfAuthors(),
                hasItem(arg1));
        assertThat("Warna salah",
                wonderfulQuotePage.getColorFromQuotePanel(arg0),
                containsString(arg2));
    }

    @When("^user click table view$")
    public void userClickTableView(){
        // Write code here that turns the phrase above into concrete actions
        wonderfulQuotePage.clickViewTable();
    }

    @And("^user hover blue button$")
    public void userHoverBlueButton(){
        // Write code here that turns the phrase above into concrete actions
        wonderfulQuotePage.hoverBlueButton();
    }

    @Then("^table is visible$")
    public void tableIsVisible(){
        // Write code here that turns the phrase above into concrete actions
        assertThat("table gak keliatan",
                wonderfulQuotePage.tableIsVisible(),
                equalTo(Boolean.TRUE));
    }

    @When("^user hover red button$")
    public void userHoverRedButton() {
        // Write code here that turns the phrase above into concrete actions
        wonderfulQuotePage.hoverRedButton();
    }

    @Then("^table is invisible$")
    public void tableIsInvisible() {
        // Write code here that turns the phrase above into concrete actions
        assertThat("table keliatan",
                wonderfulQuotePage.tableIsVisible(),
                equalTo(Boolean.FALSE));
    }

    @When("^user click green button$")
    public void userClickGreenButton(){
        // Write code here that turns the phrase above into concrete actions
        wonderfulQuotePage.clickGreenButton();
    }

    @Then("^table is visible after \"([^\"]*)\" seconds$")
    public void tableIsVisibleAfterSeconds(Integer arg0) {
        // Write code here that turns the phrase above into concrete actions
        assertThat("table keliatan",
                wonderfulQuotePage.tableIsVisible(arg0),
                equalTo(Boolean.TRUE));
    }

}
