package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class CheckoutInformationPage extends AbstractPage {

    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-one.html";

    @FindBy(xpath = "//input[@data-test='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@data-test='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@data-test='postalCode']")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(xpath = "//h3[@data-test = 'error']")
    private WebElement messageError;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    CheckoutInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }


    public void enterFirstName(String firstName){
        firstNameInput.clear();
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.clear();
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
    }

    public void postalCodeInput(String postalCode){
        postalCodeInput.clear();
        postalCodeInput.click();
        postalCodeInput.sendKeys(postalCode);
    }

    public void clickContinue(){
        log.info("Clicking in...");
        try {
            continueButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking continue: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continue, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickCancel(){
        log.info("Clicking in...");
        try {
            cancelButton.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking cancel: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking cancel, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public boolean hasMessageError(){
        return messageError.isDisplayed();
    }



}
