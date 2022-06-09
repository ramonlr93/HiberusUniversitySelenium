package com.hiberusuniversity.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loinButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement buttonRegister;

    @FindBy(xpath = "//a[@class='list-group-item' and contains(text(),'Register')]")
    private WebElement menuRegister;

    @FindBy(xpath = "//div[@class='form-group']//a[contains(text(),'Forgotten Password')]")
    private WebElement buttonForgottenPassword;



    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void enterEmailPassword(String email,String password) {
        inputEmail.click();
        inputEmail.sendKeys(email);
        inputPassword.click();
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        loinButton.click();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public void clickRegisterButton() {
        buttonRegister.click();
    }

    public void clickRegisterMenu() {
        menuRegister.click();
    }

    public void clickForgottenPassword() {
        buttonForgottenPassword.click();
    }

}
