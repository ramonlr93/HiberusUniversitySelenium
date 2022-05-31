package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class LoginPage extends AbstractPage {

    public static final String PAGE_URL = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return loginButton;
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(username);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean hasMessageError() {
        return errorMessage.isDisplayed();
    }


}
