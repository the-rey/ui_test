package com.gdn.qa.module.ui.training.models.response;

import lombok.Data;

import java.util.List;

@Data
public class GetProjectList {

  public Boolean success;
  public String errorMessage;
  public List<Content> content = null;
  public PageMetaData pageMetaData;

}
