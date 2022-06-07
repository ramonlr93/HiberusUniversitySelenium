package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AbstractPage{
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

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyPolicyButton;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement errorPrivacyPolicyMessage;

    @FindBy(xpath = "//div[@class='text-danger']")
    private WebElement errorMessageInputs;

    RegisterPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return registerButton;
    }

    public void enterFirstName(String name){
        firstNameInput.click();
        firstNameInput.sendKeys(name);
    }

    public void enterLastName(String lastName) {
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
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

    public void enterPasswordConfirm(String passwordConfirm) {
        passwordConfirmInput.click();
        passwordConfirmInput.sendKeys(passwordConfirm);
    }

    public void clickPrivacyPolicy() {
        privacyPolicyButton.click();
    }

    public void clickRegister() {
        registerButton.click();
    }

    public void privacyPolicyError(){
        errorPrivacyPolicyMessage.isDisplayed();
    }

    public void errorMessageInputs(){
        errorMessageInputs.isDisplayed();
    }
}
