package com.gdn.qa.module.ui.training.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

/**
 * Created by reynaldo.nathanael on 8/14/2018.
 */

@Component("com.gdn.qa.module.ui.training.pages.LandingPage")

public class LandingPage extends PageObject{
    String xpathButtonLogin = "//div[contains(text(),'Login')]";
    String xpathButtonSignUp = "//div[@class='NavBar__NavWhiteButton-JrVDi hItMDX']";
    String getEarlyAccess = "//a[@class='A__A-cCPuKx hdjhjt']";
    String title = "//title[contains(text(),'Login')]";

    public void clickButtonLogin(){
        find(By.xpath(xpathButtonLogin)).click();
    }

    public void clickButtonSignUp(){
        find(By.xpath(xpathButtonSignUp)).click();
    }

    public void clickButtonGetEarlyAccess(){
        find(By.xpath(xpathButtonLogin)).click();
    }

    public String getCurrentPageTitle(){
        return find(By.tagName("title")).getText();
    }
}
