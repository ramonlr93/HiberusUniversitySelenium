package com.hiberus.university.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletedPage extends AbstractPage{

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/success";

    @FindBy(id = "content")
    private WebElement confirmationOrderMessage;

    CheckoutCompletedPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return confirmationOrderMessage;
    }

    public boolean confirmationOrderMessage(){
       return confirmationOrderMessage.isDisplayed();

    }

}
