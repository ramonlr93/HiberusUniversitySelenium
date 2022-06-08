package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement buttonContinueRegister;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement divWarning;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement buttonLogin;
    @FindBy(id = "input-email")
    WebElement inputEmail;
    @FindBy(id = "input-password")
    WebElement inputPassword;
    @FindBy(xpath = "//div[@class='form-group']//child::a")
    WebElement linkForgottenPassword;

    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return buttonLogin;
    }

    public boolean existInputEmail() {
        return inputEmail.isDisplayed();
    }

    public boolean existInputPassword() {
        return inputPassword.isDisplayed();
    }

    public boolean existLinkForgottenPassword() {
        return linkForgottenPassword.isDisplayed();
    }

    public boolean existButtonContinueRegister() {
        return buttonContinueRegister.isDisplayed();
    }

    public boolean existButtonLogin() {
        return buttonLogin.isDisplayed();
    }

    public void writeInputEmail(String text) {
        inputEmail.sendKeys(text);
    }

    public void writeInputPassword(String text) {
        inputPassword.sendKeys(text);
    }

    public void clickButtonLogin() {
        buttonLogin.click();
    }

    public void clickLinkForgottenPassword() {
        linkForgottenPassword.click();
    }

    public boolean existDivWarning(){
        return divWarning.isDisplayed();
    }
}
