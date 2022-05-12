package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends AbstractPage {

    public static final String PAGE_URL = "https://www.saucedemo.com/";

    @FindBy(xpath = "//input[@data-test='username']")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "//h3[@data-test='error']")
    private WebElement errorMessage;


    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return loginButton;

    }

    public void enterPassword(String password){
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void enterUsername(String username){
        usernameInput.click();
        usernameInput.sendKeys(username);
    }

    public void clickLogin(){
        log.info("logging in...");
        try {
            loginButton.submit();
        } catch (TimeoutException e) {
            log.info("Timeout clicking login: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking login, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public boolean hasMessageError(){
        return errorMessage.isDisplayed();
    }


}
