package com.gdn.qa.module.ui.training.data;

import com.gdn.qa.automation.core.restassured.ResponseApi;
import com.gdn.qa.module.ui.training.models.response.GetProjectList;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("com.gdn.qa.module.ui.training.data.BadakData")
public class BadakData {
  private ResponseApi<GetProjectList> projectResponse;
}
