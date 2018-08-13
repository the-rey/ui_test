package com.gdn.qa.module.ui.training.api.services;

import com.gdn.qa.automation.core.json.JsonApi;
import com.gdn.qa.automation.core.restassured.ResponseApi;
import com.gdn.qa.automation.core.restassured.ServiceApi;
import com.gdn.qa.module.ui.training.models.response.GetProjectList;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.gdn.qa.module.ui.training.api.services.BadakController")
public class BadakController extends ServiceApi {

  @Autowired
  JsonApi jsonApi;

  public ResponseApi<GetProjectList> getProject() {
    Response response =
        service("badak")
            .queryParam("page", "0")
            .queryParam("size", "10")
            .get("/master/projects");

    response.getBody().prettyPrint();

    return jsonApi.fromJson(response, GetProjectList.class);
  }
}
