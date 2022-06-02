package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepOnePage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-one.html";

    @FindBy(id = "first-name")
    private WebElement firstNameImput;

    @FindBy(id = "last-name")
    private WebElement lastNameImput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeImput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    CheckOutStepOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return firstNameImput;
    }

    public void enterFirstName(String firstName){
        firstNameImput.click(); //Indiferente usarlo antes o despues de clear
        firstNameImput.clear(); //Eliminar datos antes de introducir otros
        firstNameImput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameImput.click();
        lastNameImput.clear();
        lastNameImput.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode){
        postalCodeImput.click();
        postalCodeImput.clear();
        postalCodeImput.sendKeys(postalCode);
    }

    public void fillInformation(String firstName, String lastName, String postalCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public void clickContinue(){
        continueButton.click();
    }

    public void clickCancel(){
        cancelButton.click();
    }

}
