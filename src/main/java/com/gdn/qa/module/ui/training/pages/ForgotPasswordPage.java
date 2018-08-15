package com.gdn.qa.module.ui.training.pages;

import net.serenitybdd.core.pages.PageObject;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

/**
 * Created by reynaldo.nathanael on 8/14/2018.
 */

@Component("com.gdn.qa.module.ui.training.pages.ForgotPasswordPage")

public class ForgotPasswordPage extends PageObject{

    String xpathPageHeader = "//div[@class='FormStyles__TitleText-jIQhry egmmfl']";

    public String getXpathInputEmail() {
        return xpathInputEmail;
    }

    public void setXpathInputEmail(String xpathInputEmail) {
        this.xpathInputEmail = xpathInputEmail;
    }

    public String getXpathButtonSendInstruction() {
        return xpathButtonSendInstruction;
    }

    public void setXpathButtonSendInstruction(String xpathButtonSendInstruction) {
        this.xpathButtonSendInstruction = xpathButtonSendInstruction;
    }

    public String getXpathHeaderInstructionSent() {
        return xpathHeaderInstructionSent;
    }

    public void setXpathHeaderInstructionSent(String xpathHeaderInstructionSent) {
        this.xpathHeaderInstructionSent = xpathHeaderInstructionSent;
    }

    String xpathInputEmail = "//input[@placeholder='e.g. janedoe@example.com']";
    String xpathButtonSendInstruction = "//button[@class='FormStyles__Button-dtgbLf jPIZvl']";
    String xpathHeaderInstructionSent = "//div[@class='FormStyles__TitleText-jIQhry egmmfl']";

    public void insertEmail(String email){
        find(By.xpath(xpathInputEmail)).type(email);
    }

    public void clickButtonSendInstruction(){
        find(By.xpath(xpathButtonSendInstruction)).click();
    }

    public Boolean bannerInstructionSentIsVisible(){
        return find(By.xpath(xpathHeaderInstructionSent)).isVisible();
    }

}
