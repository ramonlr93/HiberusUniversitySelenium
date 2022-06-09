package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";
    @FindBy(id = "input-email")
    WebElement emailField;
    @FindBy(id = "input-password")
    WebElement passwordField;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement loginButton;
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
    public void fillEmail(String email) {
        emailField.sendKeys(email);
    }
    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickOnLogin(){
        loginButton.click();
    }
    public String loginSucceed() {
        return getDriver().getCurrentUrl();
    }
}