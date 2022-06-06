package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(id = "input-firstname")
    private WebElement nameInput;
    @FindBy(id = "input-email")
    private WebElement lastNameInput;
    @FindBy(id = "input-lastname")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(id = "input-confirm")
    private WebElement passwordInput2;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
    private WebElement privacyPolicyCheckbox;


    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // GETTERS & SETTERS
    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public void setName(String name) {
        nameInput.sendKeys(name);
    }

    public void setLastName(String lastname) {
        lastNameInput.sendKeys(lastname);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setPassword(String passw) {
        passwordInput.sendKeys(passw);
        passwordInput2.sendKeys(passw);
    }

    public void setTelephone(String number) {
        telephoneInput.sendKeys(number);
    }

    // METODOS
    public void clickContinue() {
        continueButton.click();
    }

    public void acceptPrivacyPolicy() {
        privacyPolicyCheckbox.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}
