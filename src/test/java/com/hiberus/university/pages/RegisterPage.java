package com.hiberus.university.pages;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class RegisterPage extends AbstractPage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

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
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//label[contains(@class,'radio')]")
    private WebElement radioButton;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agreePrivacyPolicy;

    @FindBy(xpath = "//label[@class='radio-inline']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
    private WebElement errorFirstNameMessage;

    @FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
    private WebElement errorLastNameMessage;

    @FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
    private WebElement errorEmailMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement alreadyEmailMessage;

    @FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
    private WebElement errorPasswordMessage;

    @FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
    private WebElement errorMatchPasswordMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningAgreePolicy;


    RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmailRandom() {
        emailInput.clear();
        emailInput.click();
        String emailRand = RandomStringUtils.randomAlphanumeric(10).toLowerCase() + "@prueba.com";
        emailInput.sendKeys(emailRand);
    }

    public void enterTelephone(String telephone) {
        telephoneInput.clear();
        telephoneInput.click();
        telephoneInput.sendKeys(telephone);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void enterPasswordConfirmation(String passwordConfirm) {
        passwordConfirmInput.clear();
        passwordConfirmInput.click();
        passwordConfirmInput.sendKeys(passwordConfirm);
    }

    public void fillInformationEmailRand(String firstName, String lastName, String telephone, String password, String passwordConfirm) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmailRandom();
        enterTelephone(telephone);
        enterPassword(password);
        enterPasswordConfirmation(passwordConfirm);
    }

    public void fillInformation(String firstName, String lastName, String email, String telephone, String password, String passwordConfirm) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterTelephone(telephone);
        enterPassword(password);
        enterPasswordConfirmation(passwordConfirm);
    }

    public void clickSubscribeNewsletter() {
        radioButton.findElement(By.xpath("./child::input[@value='1']")).click();
    }

    public void clickAgreePolicy() {
        agreePrivacyPolicy.click();
    }

    public void clickContinueButton() {
        continueButton.submit();
    }

    private boolean hasRegisterError(WebElement webElement, String messageError) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println(messageError);
        }
        return false;
    }
       public boolean hasRegisterFirstNameError() {
        return hasRegisterError(errorFirstNameMessage, "No error message in the first name input");
    }

    public boolean hasRegisterLastNameError() {
        return hasRegisterError(errorLastNameMessage, "No error message in the last name input");
    }

    public boolean hasRegisterEmailError() {
        return hasRegisterError(errorEmailMessage, "No error message in the email input");
    }

    public boolean hasRegisterEmailAlert() {
        return hasRegisterError(alreadyEmailMessage, "No error message that the email is already used");
    }

    public boolean hasRegisterPasswordError() {
        return hasRegisterError(errorPasswordMessage, "No error message in the password input");
    }

    public boolean hasRegisterPasswordUnmatchError() {
        return hasRegisterError(errorMatchPasswordMessage, "No error message that password and password confirmation are unmatched");
    }

    public boolean hasRegisterPolicyWarning() {
        return hasRegisterError(warningAgreePolicy, "No warning message in the last name input");
    }


}

