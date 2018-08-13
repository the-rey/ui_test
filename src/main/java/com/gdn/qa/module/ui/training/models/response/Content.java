package com.gdn.qa.module.ui.training.models.response;

import lombok.Data;

import java.util.Date;

@Data
public class Content {

  public Integer id;
  public String projectName;
  public String jiraKey;
  public String testlinkKey;
  public String labelBugUat;
  public String labelBugProduction;
  public Boolean enable;
  public Integer minDDPYellow;
  public Integer minDDPGreen;
  public Integer minACYellow;
  public Integer minACGreen;
  public String createdBy;
  public Date createdDate;
  public Date timestamp;
  public Object updatedBy;

}
