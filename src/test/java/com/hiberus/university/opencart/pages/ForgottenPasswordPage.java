package com.hiberus.university.opencart.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class ForgottenPasswordPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/forgotten";

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement continueButton;

    ForgottenPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void clickContinueButton() {
        log.info("clicking...");
        try {
            continueButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking continueButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continueButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }
}
