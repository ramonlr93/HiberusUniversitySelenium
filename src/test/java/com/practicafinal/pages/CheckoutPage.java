package com.practicafinal.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.xml.crypto.Data;
import java.util.List;

public class CheckoutPage extends BasePage{

    @FindBy(id="input-email")
    private WebElement inputEmail;

    @FindBy(id="input-password")
    private WebElement inputPassword;

    @FindBy(id="button-login")
    private WebElement loginBtn;

    @FindBy(xpath="//input[@name='payment_address' and @value='new']")
    private WebElement radioBtnNewDataBill;

    @FindBy(xpath="//input[@type='text']")
    private List<WebElement> formNewData;

    @FindBy(id="input-payment-country")
    private WebElement countryList;

    @FindBy(xpath="//option[@value='195']")
    private WebElement country;

    @FindBy(id="input-payment-zone")
    private WebElement regionList;

    @FindBy(id="//option[@value='2972']")
    private WebElement region;

    @FindBy(id="button-payment-address")
    private WebElement continuePaymentAd;

    @FindBy(xpath="//input[@name='shipping_address' and @value='new']")
    private WebElement radioBtnNewDataDelivery;

    @FindBy(id="input-payment-country")
    private WebElement countryList2;

    @FindBy(id="input-payment-zone")
    private WebElement regionList2;

    @FindBy(id="button-shipping-address")
    private WebElement continueShippingAd;

    @FindBy(id="button-shipping-method")
    private WebElement continueShippingMet;

    @FindBy(xpath="//input[@type='checkbox']")
    private WebElement checkTerms;

    @FindBy(xpath="//input[@type='checkbox' and @name='agree' ]")
    private WebElement checkTermsGuest;

    @FindBy(id="button-payment-method")
    private WebElement continuePaymentMet;

    @FindBy(id="button-confirm")
    private WebElement confirmBtn;

    @FindBy(xpath="//input[@type='radio' and @value='guest']")
    private WebElement guestRadio;

    @FindBy(id="button-account")
    private WebElement continueAsGuest;
    @FindBy(id="button-guest")
    private WebElement continueGuestForm;


    CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void loginToCheckout(){
        loginBtn.click();
    }
    public void selectNewData(){
        radioBtnNewDataBill.click();
    }
    public void fillForm1(DataTable data){
        List<String> dataForm = data.asList(String.class);
        int j =0;
        for(int i=1;i<8;i++){
            formNewData.get(i).click();
            formNewData.get(i).sendKeys(dataForm.get(j));
            j++;
        }
        Select countryListPay = new Select(countryList);
        countryListPay.selectByVisibleText("Spain");
        Select regionListPay = new Select(regionList);
        regionListPay.selectByVisibleText("Albacete");
        continuePaymentAd.click();
    }

    public void fillFormAgain(DataTable data){
        wait.until(ExpectedConditions.visibilityOf(radioBtnNewDataDelivery)).isDisplayed();
        radioBtnNewDataDelivery.click();
        List<String> dataForm = data.asList(String.class);
        int j=0;
        for(int i=8;i<15;i++){
            formNewData.get(i).click();
            formNewData.get(i).sendKeys(dataForm.get(j));
            j++;
        }
        Select countryListShip = new Select(countryList2);
        countryListShip.selectByVisibleText("Spain");
        Select regionListShip = new Select(regionList2);
        regionListShip.selectByVisibleText("Albacete");
        continueShippingAd.click();
    }

    public void finishOrder() {
        continueShippingMet.click();
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentMet));
        checkTerms.click();
        continuePaymentMet.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        confirmBtn.click();
    }

    public void madeOrderWithSaveData(){
        continuePaymentAd.click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShippingAd));
        continueShippingAd.click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShippingMet));
        continueShippingMet.click();
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentMet));
        checkTerms.click();
        continuePaymentMet.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        confirmBtn.click();
    }

    public void selectMadeAsGuest(){
        guestRadio.click();
        continueAsGuest.click();
    }

    public void fillFormAsGuest(DataTable dataTable) throws InterruptedException {
        List<String> dataForm = dataTable.asList(String.class);
        int j =0;
        Thread.sleep(2000);
        for(int i=2;i<11;i++){
            formNewData.get(i).click();
            formNewData.get(i).sendKeys(dataForm.get(j));
            j++;
        }
        Select countryListPay = new Select(countryList);
        countryListPay.selectByVisibleText("Spain");
        Select regionListPay = new Select(regionList);
        regionListPay.selectByVisibleText("Albacete");
        continueGuestForm.click();
    }
    public void finishOrderAsGuest(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShippingMet));
        continueShippingMet.click();
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentMet));
        checkTermsGuest.click();
        continuePaymentMet.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        confirmBtn.click();

    }
}
