package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WithEmailAndPasswordPage {

    public static final String LOGIN_PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;



    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return loginButton;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
