package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage{
    public static final String PAGE_URL = "https://opencart.abstracta.us/";

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/login']")
    private WebElement loginButton;

    HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return myAccountButton;
    }

    public void clickGoToLogin(){
        myAccountButton.click();
        loginButton.click();
    }
}
