package com.gdn.qa.module.ui.training.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.mockito.internal.matchers.Find;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("com.gdn.qa.module.ui.training.pages.WonderfulQuotePage")
public class WonderfulQuotePage extends PageObject {

    String xpathInputTxtQuote = "//textarea[@placeholder='input quotes here']";
    String xpathInputAuthorQuote = "//input[@placeholder=\"input author's name here\"]";
    String xpathSelectBackgroundColor ="//select[@class='form-control']";
    String xpathButtonAddQuote = "//button[@class='btn btn-primary']";
    String xpathListOfQuotes = "//div[@class='quote']";
    String xpathListOfAuthors ="//div[@class='author']";
    String xpathButtonViewTable = "//a[contains(text(),'Table View')]";
    String xpathButtonBlue = "//button[contains(text(),'Hover Me To See Table')]";
    String xpathButtonRed = "//button[@class='btn btn-danger']";
    String xpathButtonGreen = "//button[@class='btn btn-success']";
    String xpathTable = "//table[@class='table table-bordered table-striped']";


    public void inputTextQuote(String txt){
        find(By.xpath(xpathInputTxtQuote)).type(txt);
    }

    public void inputTextAuthor(String txt){
        find(By.xpath(xpathInputAuthorQuote)).type(txt);
    }

    public void selectBackgroundColor(String color){
        find(By.xpath(xpathSelectBackgroundColor)).selectByVisibleText(color);
    }

    public void clickButtonAddQuote(){
        find(By.xpath(xpathButtonAddQuote)).click();
    }

    public List<String> getListOfQuotes(){
        List<WebElementFacade> listOfQuotes = findAll(By.xpath(xpathListOfQuotes));
        List<String> result = new ArrayList<>();
        for(WebElementFacade quote : listOfQuotes){
            result.add(quote.getText());
        }
        return result;
    }

    public List<String> getListOfAuthors(){
        return findAll(By.xpath(xpathListOfAuthors))
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public WebElementFacade getElementFromQuote(String quote){
        return find(By.xpath("//q[contains(text(),'"+quote+"')]/ancestor::div[@class='panel panel-default']"));
    }

    public String getColorFromQuotePanel(String quote){
        //return getElementFromQuote(quote).getCssValue("background-color");
        return getElementFromQuote(quote).getAttribute("style");
    }

    public void clickViewTable(){
        find(By.xpath(xpathButtonViewTable)).click();
    }

    public void hoverBlueButton(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(find(By.xpath(xpathButtonBlue))).build().perform();
    }

    public void hoverRedButton(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(find(By.xpath(xpathButtonRed))).build().perform();
    }

    public void clickGreenButton(){
        find(By.xpath(xpathButtonGreen)).click();
    }

    public Boolean tableIsVisible(){
        return find(By.xpath(xpathTable)).isCurrentlyVisible();
    }

    public Boolean tableIsVisible(Integer timeout){

        WebElementFacade table = find(By.xpath(xpathTable));
        table.setImplicitTimeout(Duration.ofSeconds(timeout));

        return table.isVisible();
    }
}
