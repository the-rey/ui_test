package com.gdn.qa.module.ui.training.api.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gdn.common.web.wrapper.response.GdnBaseRestResponse;
import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.qa.automation.core.json.JsonApi;
import com.gdn.qa.automation.core.restassured.ResponseApi;
import com.gdn.qa.automation.core.restassured.ServiceApi;
import com.gdn.qa.automation.core.template.TemplateApi;
import com.gdn.qa.module.ui.training.data.DeletePendingCartData;
import com.gdn.qa.module.ui.training.properties.CartDataProperties;
import com.gdn.x.cart.rest.web.model.response.PayCartResponse;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("com.gdn.qa.module.ui.training.api.services.PendingCartController")
public class PendingCartController extends ServiceApi {

    @Autowired
    TemplateApi templateApi;

    @Autowired
    JsonApi jsonApi;

    @Autowired
    DeletePendingCartData deletePendingCartModels;

    @Autowired
    CartDataProperties cartDataProperties;

    public ResponseApi<GdnBaseRestResponse> deletePendingCart() {
        Response response = service("xcart").log().all()
                .queryParam("cartId", deletePendingCartModels.getCartId())
                .queryParam("requestParams", "{}")
                .delete("/pendingcart/deletePendingCart");

        response.getBody().prettyPrint();

        return jsonApi.fromJson(response, GdnBaseRestResponse.class);
    }

    public GdnRestSingleResponse<PayCartResponse> payOrder() {
        HashMap<String, String> data = new HashMap<>();
        data.put("cartId", cartDataProperties.get("cartId"));
        String requestBody = templateApi.create("request/body/PayOrder", data);
        System.out.println("requestBody:" + requestBody);
        String response = service("xcart").log().all()
                .queryParam("username", cartDataProperties.get("cartId"))
                .queryParam("requestParams", "{}")
                .body(requestBody)
                .post("/pendingcart/payOrder")
                .getBody().prettyPrint();

        return jsonApi.fromJson(response, new TypeReference<GdnRestSingleResponse<PayCartResponse>>() {
        });
    }
}
