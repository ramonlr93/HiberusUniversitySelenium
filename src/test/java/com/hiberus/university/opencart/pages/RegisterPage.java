package com.hiberus.university.opencart.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class RegisterPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(id = "account-register")
    private WebElement registerContainer;

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(id = "input-confirm")
    private WebElement confirmInput;

    @FindBy(xpath = "//input[@type='radio' and @name='newsletter' and @value='1' ]")
    private WebElement newsletterBox;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement privacyPolicyButton;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='text-danger' and text()='Password confirmation does not match password!']")
    private WebElement passwordConfirmErrorMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible' and text()=' Warning: E-Mail Address is already registered!']")
    private WebElement emailAlreadyRegisteredErrorMessage;

    @FindBy(xpath = "//div[@class='text-danger' and text()='First Name must be between 1 and 32 characters!']")
    private WebElement firstNameErrorMessage;

    @FindBy(xpath = "//div[@class='text-danger' and text()='Last Name must be between 1 and 32 characters!']")
    private WebElement lastNameErrorMessage;

    @FindBy(xpath = "//div[@class='text-danger' and text()='E-Mail Address does not appear to be valid!']")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//div[@class='text-danger' and text()='Telephone must be between 3 and 32 characters!']")
    private WebElement telephoneErrorMessage;

    @FindBy(xpath = "//div[@class='text-danger' and text()='Password must be between 4 and 20 characters!']")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible' and text()=' Warning: You must agree to the Privacy Policy!']")
    private WebElement privacyPolicyErrorMessage;

    RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String first_name) {
        firstNameInput.click();
        firstNameInput.sendKeys(first_name);
    }

    public void enterLastName(String last_name) {
        lastNameInput.click();
        lastNameInput.sendKeys(last_name);
    }

    public void enterEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        telephoneInput.click();
        telephoneInput.sendKeys(telephone);
    }

    public void enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void enterPasswordConfirm(String password_confirm) {
        confirmInput.click();
        confirmInput.sendKeys(password_confirm);
    }

    public void checkNewsletterBox() {
        log.info("clicking...");
        try {
            newsletterBox.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking newsletterBox: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking newsletterBox, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void checkPrivacyPolicy() {
        log.info("checking...");
        try {
            privacyPolicyButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking privacyPolicyButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking privacyPolicyButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickContinue() {
        log.info("clicking...");
        try {
            continueButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking continueButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continueButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public boolean passwordConfirmError() {
        return passwordConfirmErrorMessage.isDisplayed();
    }

    public boolean emailAlreadyRegisteredError() {
        return emailAlreadyRegisteredErrorMessage.isDisplayed();
    }

    public boolean firstNameError() {
        return firstNameErrorMessage.isDisplayed();
    }

    public boolean lastNameError() {
        return lastNameErrorMessage.isDisplayed();
    }

    public boolean emailError() {
        return emailErrorMessage.isDisplayed();
    }

    public boolean telephoneError() {
        return telephoneErrorMessage.isDisplayed();
    }

    public boolean passwordError() {
        return passwordErrorMessage.isDisplayed();
    }

    public boolean privacyPolicyError() {
        return privacyPolicyErrorMessage.isDisplayed();
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return registerContainer;
    }

}