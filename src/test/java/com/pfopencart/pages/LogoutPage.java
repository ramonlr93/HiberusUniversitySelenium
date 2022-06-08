package com.pfopencart.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutPage extends AbstractPage{
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/logout";
    @FindBy(id = "input-email")
    private WebElement mailInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[contains(@value, 'Login')]")
    private WebElement loginButton;
    @FindBy(xpath = "//class[contains(@name, 'Logout')]")
    private WebElement logoutButton;
    @FindBy(className = "alert")
    private WebElement alert;
    LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
    public void enterEmail(String mail){
        wait.until(ExpectedConditions.visibilityOf(mailInput)).sendKeys(mail);
    }
    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
    }
    public void clickLogout(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).submit();
    }
    public boolean isAlertVisible(){
        try{
            return wait.until(ExpectedConditions.visibilityOf(alert)).isDisplayed();
        } catch (NoSuchElementException ns){
            return false;
        }
    }
}
