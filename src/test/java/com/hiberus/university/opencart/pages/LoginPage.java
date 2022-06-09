package com.hiberus.university.opencart.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible' and text()=' Warning: No match for E-Mail Address and/or Password.']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible' and text()=' Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.']")
    private WebElement loginAttemptsErrorMessage;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible' and text()=' An email with a confirmation link has been sent your email address.']")
    private WebElement emailConfirmationMessage;

    @FindBy(xpath = "//div[@class='form-group']/descendant::a[@href='https://opencart.abstracta.us:443/index.php?route=account/forgotten' and text()='Forgotten Password']")
    private WebElement forgottenPasswordLink;

    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void clickLogin() {
        log.info("logging in...");
        try {
            loginButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking login: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking login, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickForgottenPasswordLink() {
        log.info("clicking...");
        try {
            forgottenPasswordLink.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking forgottenPasswordLink: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking forgottenPasswordLink, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public boolean hasUsernamePasswordError() {
        return errorMessage.isDisplayed();
    }

    public boolean loginAttemptsError() {
        return loginAttemptsErrorMessage.isDisplayed();
    }

    public boolean emailConfirmation() {
        return emailConfirmationMessage.isDisplayed();
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return loginButton;
    }
}

