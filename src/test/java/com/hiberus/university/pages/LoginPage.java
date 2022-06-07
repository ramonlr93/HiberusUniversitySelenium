package com.hiberus.university.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement errorMessage;

    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/forgotten']")
    WebElement forgottenPassword;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement confinueForgottenButton;

    @FindBy(xpath = "//i[@class='fa fa-check-circle']")
    WebElement confirmationLink;

    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickLoginButton() {
        loginButton.submit();
    }

    public boolean hasLoginAlert(WebElement webElement, String message) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println(message);
        }
        return false;
    }

    public boolean hasLoginInputError() {
        return hasLoginAlert(errorMessage, "Match for E-Mail Address and/or Password.");
    }

    public boolean hasForgottenPasswordAlert() {
        return hasLoginAlert(confirmationLink, "The E-Mail Address was found in our records");
    }
    public void clickForgottenPasswordLink() {
        forgottenPassword.click();
    }
    public void clickContinueForgottenPasswordLink() {
        confinueForgottenButton.submit();
    }
}
