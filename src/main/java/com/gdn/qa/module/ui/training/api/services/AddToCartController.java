package com.gdn.qa.module.ui.training.api.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.qa.automation.core.json.JsonApi;
import com.gdn.qa.automation.core.restassured.ResponseApi;
import com.gdn.qa.automation.core.restassured.ServiceApi;
import com.gdn.qa.module.ui.training.data.AddToCartData;
import com.gdn.x.cart.rest.web.model.response.PendingCartResponse;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.gdn.qa.module.ui.training.api.services.AddToCartController")
public class AddToCartController extends ServiceApi {

    @Autowired
    JsonApi jsonApi;

    @Autowired
    AddToCartData addToCartModels;

    public ResponseApi<GdnRestSingleResponse<PendingCartResponse>> addToCart() {
        Response response = service("xcart")
                .queryParam("itemSku", addToCartModels.getItemSku())
                .queryParam("quantity", addToCartModels.getQuantity())
                .queryParam("cartId", addToCartModels.getCartId())
                .queryParam("level2MerchantCode", addToCartModels.getLevel2MerchantCode())
                .queryParam("requestParams", "{}")
                .log().all()
                .post("/pendingcart/addToCart");

        response.getBody().prettyPrint();
        return jsonApi.fromJson(response,  new TypeReference<GdnRestSingleResponse<PendingCartResponse>>() {
        });
    }
}
