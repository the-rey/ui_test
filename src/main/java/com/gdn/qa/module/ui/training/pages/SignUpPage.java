package com.gdn.qa.module.ui.training.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

/**
 * Created by reynaldo.nathanael on 8/15/2018.
 */

@Component("com.gdn.qa.module.ui.training.pages.SignUpPage")

public class SignUpPage extends PageObject{

    String xpathButtonLogin = "//a[contains(text(),'Login to your account')]";

    public void clickButtonLogin(){
        find(By.xpath(xpathButtonLogin)).click();
    }
}
