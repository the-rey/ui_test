package com.gdn.qa.module.ui.training.api.interceptors;

import com.gdn.qa.automation.core.restassured.ServiceInterceptor;
import com.gdn.qa.module.ui.training.properties.DefaultProperties;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.gdn.qa.module.ui.training.api.interceptors.MemberInterceptor")
public class MemberInterceptor implements ServiceInterceptor {

    @Autowired
    private DefaultProperties properties;

    @Override
    public void prepare(RequestSpecification requestSpecification) {
        requestSpecification.header("content-type", "application/json")
                .queryParam("storeId", properties.getStoreId())
                .queryParam("channelId", properties.getChannelId())
                .queryParam("clientId", properties.getClientId())
                .queryParam("requestId", properties.getRequestId());
    }

    @Override
    public boolean isSupport(String serviceName) {
        if (serviceName.equalsIgnoreCase("member")) {
            return true;
        }return false;
    }
}
