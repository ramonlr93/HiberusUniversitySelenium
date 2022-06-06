package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php"; // url del proyecto del home

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccount;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return myAccount;
    }

    public void clickMyAccount() {
        myAccount.click();
    }

}
