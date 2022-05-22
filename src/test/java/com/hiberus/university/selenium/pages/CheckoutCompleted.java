package com.hiberus.university.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompleted extends AbstractPage{
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-complete.html";

    @FindBy(xpath = "//div[@class='complete-text']")
    private WebElement completeMessage;

    public CheckoutCompleted(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return completeMessage;
    }

    public String getCompleteMessage(){
        return completeMessage.getText();
    }
}
