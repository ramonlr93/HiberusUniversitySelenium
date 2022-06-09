package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class CheckoutPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";
    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameField;
    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameField;
    @FindBy(id = "input-payment-company")
    private WebElement companyField;
    @FindBy(id = "input-payment-address-1")
    private WebElement companyAdress1Field;
    @FindBy(id = "input-payment-address-2")
    private WebElement companyAdress2Field;
    @FindBy(id = "input-payment-city")
    private WebElement cityField;
    @FindBy(id = "input-payment-postcode")
    private WebElement postCodeField;
    @FindBy(id = "input-payment-country")
    private WebElement countryCombo;
    @FindBy(xpath = "//option[@value='195']")
    private WebElement countrySelection;
    @FindBy(id = "input-payment-zone")
    private WebElement zoneCombo;
    @FindBy(xpath = "//option[@value='3021']")
    private WebElement zoneSelection;
    @FindBy(id = "button-payment-address")
    private WebElement continueBillDtlsBtn;
    @FindBy(id = "button-shipping-address")
    private WebElement continueShipBtn;
    @FindBy(xpath = "//textarea[@class='form-control']")
    private WebElement commentsArea;
    @FindBy(id = "button-shipping-method")
    private WebElement delyMthdBtn;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkbox;
    @FindBy(id = "button-payment-method")
    private WebElement payMthdBtn;
    @FindBy(id="button-confirm")
    private WebElement confirmBtn;
    CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
    public void fillBillingDetails(){
        continueBillDtlsBtn.click();
    }
    public void fillDeliveryDetails(){
        continueShipBtn.click();
    }
    public void fillDeliveryComments(String comments){
        commentsArea.sendKeys(comments);
    }
    public void clickDelMthd(){
        delyMthdBtn.click();
    }
    public void checkAgrmnt(){
        checkbox.click();
    }
    public void payMthdClick(){
        payMthdBtn.click();
    }
    public void confirmOrder(){
        confirmBtn.click();
    }
    public String orderConfirmed(){
        return getDriver().getCurrentUrl();
    }
}