package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(id = "input-firstname")
    WebElement inputFirstName;
    @FindBy(id = "input-lastname")
    WebElement inputLastName;
    @FindBy(id = "input-email")
    WebElement inputEmail;
    @FindBy(id = "input-telephone")
    WebElement inputTelephone;
    @FindBy(id = "input-password")
    WebElement inputPassword;
    @FindBy(id = "input-confirm")
    WebElement inputPasswordConfirm;
    @FindBy(xpath = "//div[@class='form-group']")
    WebElement divSubscribe;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkPrivacyPolicy;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement inputContinue;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement divWarning;
    @FindBy(xpath = "//div[@class='text-danger']")
    List<WebElement> listTextDanger;
    @FindBy(xpath = "//div[@id='content']//child::p//child::a")
    WebElement linkLoginPage;


    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return inputPassword;
    }

    public boolean existInputFirstName() {
        return inputFirstName.isDisplayed();
    }

    public boolean existInputLastName() {
        return inputLastName.isDisplayed();
    }

    public boolean existInputEmail() {
        return inputEmail.isDisplayed();
    }

    public boolean existInputTelephone() {
        return inputTelephone.isDisplayed();
    }

    public boolean existInputPassword() {
        return inputPassword.isDisplayed();
    }

    public boolean existInputPasswordConfirm() {
        return inputPasswordConfirm.isDisplayed();
    }

    public boolean existDivSubscribe() {
        return divSubscribe.isDisplayed();
    }

    public boolean existCheckPrivacyPolicy() {
        return checkPrivacyPolicy.isDisplayed();
    }

    public boolean existButtonContinue() {
        return inputContinue.isDisplayed();
    }

    public void writeInputFirstName(String text) {
        inputFirstName.sendKeys(text);
    }

    public void writeInputLastName(String text) {
        inputLastName.sendKeys(text);
    }

    public void writeInputEmail(String text) {
        inputEmail.sendKeys(text);
    }

    public void writeInputTelephone(String text) {
        inputTelephone.sendKeys(text);
    }

    public void writeInputPassword(String text) {
        inputPassword.sendKeys(text);
    }

    public void writeInputPasswordConfirm(String text) {
        inputPasswordConfirm.sendKeys(text);
    }

    public void clickCheckPrivacyPolicy() {
        checkPrivacyPolicy.click();
    }

    public void clickButtonContinue() {
        inputContinue.click();
    }

    public int sizeOflistTextDanger(){
        return listTextDanger.size();
    }

    public String getWarningText(){
        return divWarning.getText();
    }

    public void clickLoginPageLink(){
        linkLoginPage.click();
    }
}
