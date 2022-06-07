package com.opencart.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-firstname")
    WebElement firstNameField;

    @FindBy(id = "input-lastname")
    WebElement lastNameField;

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-telephone")
    WebElement telephoneField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;

    @FindBy(name = "newsletter")
    WebElement acceptingNewsletterButton;

    @FindBy(name = "agree")
    WebElement agreePrivacyPolicyButton;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//div[@class='text-danger'][1]")
    WebElement errorMessage;

    @FindBy(xpath = "//h1[text()='Account']")
    WebElement successMessage;


    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public void enterRegistrationData (String firstName, String lastName, String email, String telephone, String password, String confirmPassword){
        sendText(firstNameField, firstName);
        sendText(lastNameField, lastName);
        sendText(emailField, email);
        sendText(telephoneField, telephone);
        sendText(passwordField, password);
        sendText(passwordConfirmField, confirmPassword);
    }

    public void acceptingNewsletter(){
        click(acceptingNewsletterButton);
    }

    public void acceptingPrivacyPolicy(){
        click(agreePrivacyPolicyButton);
    }

    public void clickContinue(){
        click(continueButton);
    }

    public boolean getMessageError() {
        return errorMessage.isDisplayed();
    }
}
