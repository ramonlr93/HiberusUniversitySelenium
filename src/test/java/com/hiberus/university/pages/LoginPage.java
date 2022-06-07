package com.hiberus.university.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";

    @FindBy(id = "input-email")
    WebElement loginEmail;

    @FindBy(id = "input-password")
    WebElement loginPassword;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement errorMessage;

    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void enterLoginEmail(String email) {
        loginEmail.clear();
        loginEmail.click();
        loginEmail.sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        loginPassword.clear();
        loginPassword.click();
        loginPassword.sendKeys(password);
    }

    public void fillLoginInformation(String email, String password) {
        enterLoginEmail(email);
        enterLoginPassword(password);
    }

    public void clickLoginButton() {
        loginButton.submit();
    }
    public boolean hasLoginError() {
        try {
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("No error message in the first name input");
        }
        return false;
    }
}
