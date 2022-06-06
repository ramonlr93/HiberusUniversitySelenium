package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends WithEmailAndPasswordPage {

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privatePolicyCheckBox;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='text-danger'][1]")
    private WebElement fieldErrorMessageDiv;


    RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public RegisterPage enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterPage enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterPage enterTelephone(long telephone) {
        telephoneInput.clear();
        telephoneInput.sendKeys(telephone + "");
        return this;
    }

    public RegisterPage enterConfirmPassword(String password) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(password);
        return this;
    }

    public RegisterPage clickPrivatePolicy() {
        privatePolicyCheckBox.click();
        return this;
    }

    public void clickContinue() {
        continueButton.click();
    }

    public String getFieldMessageError() {
        return fieldErrorMessageDiv.getText();
    }
}
