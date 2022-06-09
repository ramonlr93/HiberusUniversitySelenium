package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
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
    private WebElement confirmPasswordInput;

    @FindBy(name = "agree")
    private WebElement privatePolicyCheck;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningPrivatePolicy;

    @FindBy(xpath = "//div[@class='text-danger']")
    private WebElement errorMessage;

    RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return firstNameInput;
    }

    public void enterFirstName(String firstName){
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email){
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterTelephone(String telephone){
        telephoneInput.click();
        telephoneInput.sendKeys(telephone);
    }

    public void enterPassword(String password){
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword){
        confirmPasswordInput.click();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void checkPrivatePolicy(){
        privatePolicyCheck.click();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public boolean hasPrivatePolicyError() {
        return warningPrivatePolicy.isDisplayed();
    }

    public String errorMessageDisplay(){
        if(errorMessage.isDisplayed()){
            return errorMessage.getText();
        }else{
            return null;
        }
    }

}
