package com.gdn.qa.module.ui.training.data;

import com.gdn.common.web.wrapper.response.GdnBaseRestResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("com.gdn.qa.module.ui.training.data.DeletePendingCartData")
public class DeletePendingCartData {
    private String cartId;
    private GdnBaseRestResponse response;
}
