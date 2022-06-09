package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class RegisterPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement continueButton;
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
    WebElement confirmField;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement agreementCheck;
    RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
    public void fillFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }
    public void fillLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    public void fillEmail(String email) {
        emailField.sendKeys(email);
    }
    public void fillTelephone(String phoneNumber) {
        telephoneField.sendKeys(phoneNumber);
    }
    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void fillConfirm(String confirm) {
        confirmField.sendKeys(confirm);
    }
    public void clickOnAgreement() {
        agreementCheck.click();
    }

    public void clickOnCOntinue() {
        continueButton.click();
    }
    public String success(){
        return getDriver().getCurrentUrl();
    }
}