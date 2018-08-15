package com.gdn.qa.module.ui.training.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

/**
 * Created by reynaldo.nathanael on 8/14/2018.
 */

@Component("com.gdn.qa.module.ui.training.pages.LoginPage")

public class LoginPage extends PageObject{
    String xpathButtonForgotPassword = "//a[contains(text(),'Forgot password?')]";
    String xpathButtonCreateAccount = "//a[contains(text(),'Create account')]";
    String xpathButtonLogin = "//button[@class='FormStyles__Button-dtgbLf jPIZvl']";
    String xpathInputEmail = "//div[@class='FormStyles__FormWrapper-bgXZIs dicgLS']//div[1]//input[1]";
    String xpathInputPassword = "//div[@class='FormStyles__FormWrapper-bgXZIs dicgLS']//div[2]//input[1]";
    String xpathButtonSkip = "//button[contains(text(),'Skip')]";

    public void clickButtonLogin(){
        find(By.xpath(xpathButtonLogin)).click();
    }

    public void clickButtonForgetPassword(){
        find(By.xpath(xpathButtonForgotPassword)).click();
    }

    public void clickButtonCreateAccount(){
        find(By.xpath(xpathButtonCreateAccount)).click();
    }

    public void insertEmail(String email){
        find(By.xpath(xpathInputEmail)).type(email);
    }

    public void insertPassword(String password){
        find(By.xpath(xpathInputPassword)).type(password);
    }

    public String getCurrentPageTitle(){
        return find(By.tagName("title")).getText();
    }

    public void clickButtonSkip(){
        find(By.xpath(xpathButtonSkip)).click();
    }
}
