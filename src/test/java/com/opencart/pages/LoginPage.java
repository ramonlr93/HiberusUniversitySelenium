package com.opencart.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // GETTERS & SETTERS
    @Override
    public WebElement getPageLoadedTestElement() {
        return loginButton;
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }
    public void setPassword(String passw) {
        passwordInput.sendKeys(passw);
    }

    // METODOS
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public void clickLogin() {
        loginButton.click();
    }
}
