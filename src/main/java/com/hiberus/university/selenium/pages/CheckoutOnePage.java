package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage extends AbstractPage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueCheckoutButton;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;


    CheckoutOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void enterFistName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    public void continueCheckout() {
        continueCheckoutButton.click();
    }

    public void cancelPurchase() {
        cancelButton.click();
    }

    public void fillInputs(String firstName, String lastName, String postalCode) {
        enterFistName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public void fillInputsAndContinue(String firstName, String lastName, String postalCode) {
        enterFistName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        continueCheckout();
    }

    public boolean hasErrorMessage() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
