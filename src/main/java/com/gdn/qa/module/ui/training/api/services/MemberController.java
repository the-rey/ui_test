package com.gdn.qa.module.ui.training.api.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.qa.automation.core.json.JsonApi;
import com.gdn.qa.automation.core.restassured.ResponseApi;
import com.gdn.qa.automation.core.restassured.ServiceApi;
import com.gdn.x.member.rest.web.model.dto.response.MemberResponse;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.gdn.qa.module.ui.training.api.services.MemberController")
public class MemberController extends ServiceApi {

    @Autowired
    JsonApi jsonApi;

    public ResponseApi<GdnRestSingleResponse<MemberResponse>> findOn(String memberId) {
        Response response = service("member").log().all()
                .queryParam("memberId", memberId)
                .get("api/member/findOne");

        response.getBody().prettyPrint();

        return jsonApi.fromJson(response, new TypeReference<GdnRestSingleResponse<MemberResponse>>() {
        });
    }

}
