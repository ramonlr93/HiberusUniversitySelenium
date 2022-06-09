package com.hiberusuniversity.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(id = "input-firstname")
    private WebElement inputFirstname;

    @FindBy(id = "input-lastname")
    private WebElement inputLastname;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-telephone")
    private WebElement inputTelephone;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "input-confirm")
    private WebElement inputPasswordconfirm;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkboxAgreetos;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement buttonRegister;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='text-danger' and contains(text(),'E-Mail Address')]")
    private WebElement errorInputEmail;

    RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
    public void enterRegisterValuesRandomEmail(String name,String lastName,String email,String telephone,String password) {
        int numeroAleatorio = (int)(Math.random()*1000+1);
        inputFirstname.click();
        inputFirstname.sendKeys(name);
        inputLastname.click();
        inputLastname.sendKeys(lastName);
        inputEmail.click();
        inputEmail.sendKeys(numeroAleatorio + email);
        inputTelephone.click();
        inputTelephone.sendKeys(telephone);
        inputPassword.click();
        inputPassword.sendKeys(password);
        inputPasswordconfirm.click();
        inputPasswordconfirm.sendKeys(password);
    }

    public void enterRegisterValues(String name,String lastName,String email,String telephone,String password) {
        inputFirstname.click();
        inputFirstname.sendKeys(name);
        inputLastname.click();
        inputLastname.sendKeys(lastName);
        inputEmail.click();
        inputEmail.sendKeys(email);
        inputTelephone.click();
        inputTelephone.sendKeys(telephone);
        inputPassword.click();
        inputPassword.sendKeys(password);
        inputPasswordconfirm.click();
        inputPasswordconfirm.sendKeys(password);
    }

    public void checkCheckbox(){
        checkboxAgreetos.click();
    }

    public void clickRegisterButton(){
        buttonRegister.click();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getErrorInputEmail() {
        return errorInputEmail;
    }
}

