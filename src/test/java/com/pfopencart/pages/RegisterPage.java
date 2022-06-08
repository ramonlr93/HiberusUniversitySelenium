package com.pfopencart.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RegisterPage extends AbstractPage{

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(id = "input-firstname")
    private WebElement firstnameInput;
    @FindBy(id = "input-lastname")
    private WebElement lastnameInput;
    @FindBy(id = "input-email")
    private WebElement emailInput;
    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(id = "input-confirm")
    private WebElement confirmInput;
    @FindBy(xpath = "//input[contains(@name, 'agree')]")
    private WebElement privacyButton;
    @FindBy(xpath = "//input[contains(@value, 'Continue')]")
    private WebElement continueButton;

    @FindBy(className = "alert")
    private WebElement alert;

    RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void enterEmail(String mail){
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(mail);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
    }

    public void enterFirstname(String firstname) {
        firstnameInput.sendKeys(firstname);
    }

    public void enterLastname(String lastname) {
        lastnameInput.sendKeys(lastname);
    }

    public void enterTelephone(String telephone) {
        telephoneInput.sendKeys(telephone);
    }

    public void enterConfirm(String confirm) {
        confirmInput.sendKeys(confirm);
    }

    public void clickPrivacy() {
        privacyButton.click();
    }

    public void clickContinue() {
        continueButton.click();
    }
}
