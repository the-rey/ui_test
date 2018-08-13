package com.gdn.qa.module.ui.training.api.interceptors;

import com.gdn.qa.automation.core.restassured.ServiceInterceptor;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

@Component("com.gdn.qa.module.ui.training.api.interceptors.ServiceInterceptor")
public class BadakInterceptor implements ServiceInterceptor {
  @Override
  public boolean isSupport(String serviceName) {
    if (serviceName.equalsIgnoreCase("badak"))
      return true;
    return false;
  }

  @Override
  public void prepare(RequestSpecification requestSpecification) {
    requestSpecification.header("content-type", "application/json").log().all();
  }
}
