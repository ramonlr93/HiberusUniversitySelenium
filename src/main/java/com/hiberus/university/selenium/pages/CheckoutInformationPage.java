package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class CheckoutInformationPage extends AbstractPage {

    @FindBy(xpath = "//input[@data-test='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@data-test='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@data-test='postalCode']")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//button[@data-test='continue']")
    private WebElement continueButton;

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

}
