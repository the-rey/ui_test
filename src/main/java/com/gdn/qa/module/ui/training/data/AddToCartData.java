package com.gdn.qa.module.ui.training.data;

import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.x.cart.rest.web.model.response.PayCartResponse;
import com.gdn.x.cart.rest.web.model.response.PendingCartResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("com.gdn.qa.module.ui.training.data.AddToCartData")
public class AddToCartData {

    private String itemSku;
    private String quantity;
    private String cartId;
    private String level2MerchantCode;
    GdnRestSingleResponse<PendingCartResponse> response;
    GdnRestSingleResponse<PayCartResponse> payOrder;
}
