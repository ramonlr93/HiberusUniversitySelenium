package org.hiberus.com.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Slf4j
public class RegisterPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(xpath = "//div[@class='text-danger'")
    private static WebElement textDanger;

    //public static final String TEXT_DANGER_TEXT = textDanger.getText();

    @FindBy(id = "input-firstname")
    private WebElement inputFirstName;

    @FindBy(id = "input-lastname")
    private WebElement inputLastName;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement messageEmailRegistered;

    @FindBy(id = "input-telephone")
    private WebElement inputTelephone;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "input-confirm")
    private WebElement inputConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement policyCheckBox;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;


    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public void introducesRegisterInformation(String firstName, String lastName,
                                              String email, String telephone,
                                              String password, String confirmPassword){
        inputFirstName.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.click();
        inputLastName.sendKeys(lastName);
        inputEmail.click();
        inputEmail.sendKeys(email);
        inputTelephone.click();
        inputTelephone.sendKeys(telephone);
        inputPassword.click();
        inputPassword.sendKeys(password);
        inputConfirmPassword.click();
        inputConfirmPassword.sendKeys(confirmPassword);

    }

    public void clickPolicyCheckbox() {
        log.info("Clicks in policyCheckBox...");
        try {
            policyCheckBox.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking policyCheckBox: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking policyCheckBox, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickContinueButton() {
        log.info("Clicks in continueButton...");
        try {
            continueButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking continueButton: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking continueButton, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public boolean emailRegisteredInDataBaseMessage() {
        return messageEmailRegistered.isDisplayed();
    }


}
