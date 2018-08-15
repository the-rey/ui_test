package com.gdn.qa.module.ui.training.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

/**
 * Created by reynaldo.nathanael on 8/14/2018.
 */

@Component("com.gdn.qa.module.ui.training.pages.HomePage")

public class HomePage extends PageObject{
    public String xpathPortfolioValue = "//div[@class='LeftTab__InfoValue-kBJheS OJSpb']";
    public String xpathTabHome = "//div[contains(text(),'Home')]";
    public String xpathTabMarketplace = "//div[@class='LeftTab__TabItem-bQnqaa bmSDLG']";
    public String xpathTabBankingAndWallet = "//div[contains(text(),'Banking & Wallet')]";
    public String xpathTabHistory = "//div[contains(text(),'History')]";
    public String xpathTableCoinPairs = "//div[@class='MakeResponsive-iRTIta FItHU sc-jTzLTM gdBFAz']";
    public String xpathTableTokenSales = "//div[@class='MakeResponsive-djJboc jfLZnp sc-jTzLTM gdBFAz']";
    public String xpathBitcoinIdrPair = "//div[@class='MakeResponsive-iRTIta FItHU sc-jTzLTM gdBFAz']//tbody//tr[2]";

    public void clickTabHome(){
        find(By.xpath(xpathTabHome)).click();
    }

    public void clickTabMarketplace(){
        find(By.xpath(xpathTabMarketplace)).click();
    }

    public void clickTabBankingAndWallet(){
        find(By.xpath(xpathTabBankingAndWallet)).click();
    }

    public void clickTabHistory(){
        find(By.xpath(xpathTabHistory)).click();
    }

    public void clickBitcoinIdrPair(){
        waitForPresenceOf(xpathBitcoinIdrPair);
        find(By.xpath(xpathBitcoinIdrPair)).click();
    }

    public Boolean isPortfolioValueVisible(){
        if(find(By.xpath(xpathPortfolioValue)).isVisible())return true;
        return false;
    }
}
