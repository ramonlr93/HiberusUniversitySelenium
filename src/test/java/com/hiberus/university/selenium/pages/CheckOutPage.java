package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckOutPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    @FindBy(id = "input-email")
    WebElement inputEmail;
    @FindBy(id = "input-password")
    WebElement inputPassword;
    @FindBy(id = "button-login")
    WebElement buttonLogin;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkTermsConditions;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    List<WebElement> buttonContinue;
    @FindBy(id = "button-confirm")
    WebElement buttonConfirmOrder;
    private int num = 0;

    CheckOutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void writeInputEmail(String text) {
        inputEmail.sendKeys(text);
    }

    public void writeInputPassword(String text) {
        inputPassword.sendKeys(text);
    }

    public void clickButtonContinue() throws InterruptedException {
        Thread.sleep(1000);
        buttonContinue.get(num).click();
        num++;
    }

    public void clickButtonLogin() {
        buttonLogin.click();
    }

    public void clickButtonConfirm() {
        buttonConfirmOrder.click();
    }

    public void clickCheckTermsConditions() {
        checkTermsConditions.click();
    }
}
