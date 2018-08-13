package com.gdn.qa.module.ui.training.steps;

import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.qa.automation.core.restassured.ResponseApi;
import com.gdn.qa.automation.core.CucumberStepsDefinition;
import com.gdn.qa.module.ui.training.api.services.MemberController;
import com.gdn.qa.module.ui.training.data.MemberData;
import com.gdn.x.member.rest.web.model.dto.response.MemberResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@CucumberStepsDefinition
public class MemberSteps extends ScenarioSteps{

    @Autowired
    MemberData data;

    @Autowired
    MemberController controller;

    @Given("^\\[MemberSteps\\] create member request with userId '(.*)'$")
    public void memberstepsCreateMemberRequest(String userId) {

        data.setUserId(userId);

    }

    @When("^\\[MemberSteps\\] send get member request$")
    public void memberstepsSendGetMemberRequest() {

        ResponseApi<GdnRestSingleResponse<MemberResponse>> webService = controller.findOn(data.getUserId());

        data.setMemberResponse(webService.getResponseBody());
    }

    @Then("^\\[MemberSteps\\] create member response must equals with request$")
    public void memberstepsCreateMemberResponseMustEqualsWithRequest() {

        assertThat(data.getUserId(), equalTo(data.getMemberResponse().getValue().getMemberId()));
    }
}
