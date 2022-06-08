package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class RegisterPage extends BasePage {
    public static final String REGISTER_PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyPolicyButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningMessage;

    @FindBy(xpath = "//div[@class='text-danger']")
    private List<WebElement> dangerTextMessageList;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public void clickContinueButton() {
        log.info("Register in...");
        try {
            continueButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking continue: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking continue, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickPrivacyPolicyButton() {
        log.info("Register in...");
        try {
            privacyPolicyButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking checkPrivacyPolicyButton: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking checkPrivacyPolicyButton, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void enterFirstname(String firstName) {
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastname(String lastname) {
        lastNameInput.click();
        lastNameInput.sendKeys(lastname);
    }

    public void enterEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        telephoneInput.click();
        telephoneInput.sendKeys(telephone);
    }

    public void enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void enterPasswordConfirm(String passwordConfirm) {
        passwordConfirmInput.click();
        passwordConfirmInput.sendKeys(passwordConfirm);
    }

    public boolean warningMessageIsDisplayed() {
        return warningMessage.isDisplayed();
    }

    public String warningMessageText() {
        return warningMessage.getText();
    }

    public int getDangerTextMessageListCount() {
        return dangerTextMessageList.size();
    }

    public boolean AllMessageMandatoryAreDisplayed() {
        for (WebElement webElement : dangerTextMessageList) {
            if (!webElement.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}

