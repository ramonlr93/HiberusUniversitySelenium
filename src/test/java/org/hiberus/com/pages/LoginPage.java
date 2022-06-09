package org.hiberus.com.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement errorMessage;




    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return loginButton;
    }

    public void clickLogin() {
        log.info("Logging in...");
        try {
            loginButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking login: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking login, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public boolean hasUsernamePasswordError() {
        return errorMessage.isDisplayed();
    }
}
