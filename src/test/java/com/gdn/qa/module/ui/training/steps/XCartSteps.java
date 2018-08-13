package com.gdn.qa.module.ui.training.steps;

import com.gdn.common.web.wrapper.response.GdnBaseRestResponse;
import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.qa.automation.core.restassured.ResponseApi;
import com.gdn.qa.automation.core.CucumberStepsDefinition;
import com.gdn.qa.module.ui.training.api.services.AddToCartController;
import com.gdn.qa.module.ui.training.api.services.PendingCartController;
import com.gdn.qa.module.ui.training.data.AddToCartData;
import com.gdn.qa.module.ui.training.data.DeletePendingCartData;
import com.gdn.qa.module.ui.training.properties.CartDataProperties;
import com.gdn.x.cart.rest.web.model.response.PayCartResponse;
import com.gdn.x.cart.rest.web.model.response.PendingCartResponse;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@CucumberStepsDefinition
public class XCartSteps extends ScenarioSteps {

    @Autowired
    CartDataProperties cartDataProperties;

    @Autowired
    DeletePendingCartData deletePendingCartData;

    @Autowired
    AddToCartData addToCartData;

    @Autowired
    PendingCartController pendingCartController;

    @Autowired
    AddToCartController addToCartController;

    @Then("^\\[x-cart] payOrder request response should be true$")
    public void xCartPayOrderRequestResponseShouldBeTrue() throws Throwable {
        assertThat("Reponse success is false", addToCartData.getPayOrder().isSuccess(), equalTo(false));
    }


    @Given("^\\[x-cart] prepare delete pending cart request with properties data$")
    public void xCartPrepareDeletePendingCartRequestWithPropertiesData() throws Throwable {
        deletePendingCartData.setCartId(cartDataProperties.get("cartId"));
    }

    @When("^\\[x-cart] prepare payOrder data$")
    public void xCartPreparePayOrderData() throws Throwable {
    }

    @When("^\\[x-cart] send delete pending cart request$")
    public void xCartSendDeletePendingCartRequest() throws Throwable {
        ResponseApi<GdnBaseRestResponse> response = pendingCartController.deletePendingCart();
        deletePendingCartData.setResponse(response.getResponseBody());
    }

    @Then("^\\[x-cart] delete pending cart response should be true$")
    public void xCartDeletePendingCartResponseShouldBeTrue() throws Throwable {
        assertThat("Reponse success is false", deletePendingCartData.getResponse().isSuccess(), equalTo(true));
    }

    @Given("^\\[x-cart] prepare delete pending cart with cartId '(.*)'$")
    public void xCartPrepareDeletePendingCartWithCartId(String cartId) throws Throwable {
        deletePendingCartData.setCartId(cartId);
    }

    @Given("^\\[x-cart] prepare add to cart request with properties data$")
    public void xCartPrepareAddToCartRequestWithPropertiesData() throws Throwable {
        addToCartData.setCartId(cartDataProperties.get("cartId"));
        addToCartData.setItemSku(cartDataProperties.get("itemSku"));
        addToCartData.setLevel2MerchantCode(cartDataProperties.get("level2MerchantCode"));
        addToCartData.setQuantity(cartDataProperties.get("quantity"));
    }

    @When("^\\[x-cart] send add to cart request$")
    public void xCartSendAddToCartRequest() throws Throwable {
        ResponseApi<GdnRestSingleResponse<PendingCartResponse>> response = addToCartController.addToCart();
        addToCartData.setResponse(response.getResponseBody());
    }

    @Then("^\\[x-cart] add to cart response should be true$")
    public void xCartAddToCartResponseShouldBeTrue() throws Throwable {
        assertThat("Response sucess is false", addToCartData.getResponse().isSuccess(), equalTo(true));
    }

    @Then("^\\[x-cart] add to cart response has more or equal than (\\d+) sku in cartItems$")
    public void xCartAddToCartResponseHasMoreOrEqualThanSkuInCartItems(int sku) throws Throwable {
        assertThat("There is more or equal than " + sku + " sku in cartItems", addToCartData.getResponse().getValue().getCartItems().size(), greaterThanOrEqualTo(sku));
    }

    @Then("^\\[x-cart] add to cart response should have same item sku in cartItems$")
    public void xCartAddToCartResponseShouldHaveSameItemSkuInCartItems() throws Throwable {
        assertThat("Item SKU is different in cartItems", addToCartData.getResponse().getValue().getCartItems().get(0).getItemSku()
                , equalTo(addToCartData.getItemSku()));
    }

    @When("^\\[x-cart] send payOrder request$")
    public void xCartSendPayOrderRequest() throws Throwable {
        GdnRestSingleResponse<PayCartResponse> response = pendingCartController.payOrder();
        addToCartData.setPayOrder(response);
    }
}
