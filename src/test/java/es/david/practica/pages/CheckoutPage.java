package es.david.practica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends AbstractPage{

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    @FindBy(xpath = "//input[contains(@name, 'payment_address') and contains(@value, 'new')]")
    private WebElement newAddress;

    @FindBy(xpath = "//input[contains(@name, 'payment_address') and contains(@value, 'existing')]")
    private WebElement existingAddress;

    @FindBy(xpath = "//input[contains(@name, 'firstname')]")
    private WebElement firstname;

    @FindBy(xpath = "//input[contains(@name, 'lastname')]")
    private WebElement lastname;

    @FindBy(xpath = "//input[contains(@name, 'company')]")
    private WebElement company;

    @FindBy(xpath = "//input[contains(@name, 'address_1')]")
    private WebElement address_1;

    @FindBy(xpath = "//input[contains(@name, 'address_2')]")
    private WebElement address_2;

    @FindBy(xpath = "//input[contains(@name, 'city')]")
    private WebElement city;

    @FindBy(xpath = "//input[contains(@name, 'postcode')]")
    private WebElement postcode;

    @FindBy(id = "input-payment-country")
    private WebElement country_id;

    @FindBy(id = "input-payment-zone")
    private WebElement zone_id;

    @FindBy(id = "input-payment-zone")
    private WebElement region;

    @FindBy(id = "button-payment-address")
    private WebElement paymentButton;

    @FindBy(id = "button-shipping-address")
    private WebElement shippingButton;

    @FindBy(id = "button-shipping-method")
    private WebElement shippingMethodButton;

    @FindBy(id = "button-payment-method")
    private WebElement paymentMethodButton;

    @FindBy(xpath = "//input[contains(@name, 'agree')]")
    private WebElement termsAndConditions;

    @FindBy(id = "button-confirm")
    private WebElement confirm;

    CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void selectExistingAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(existingAddress)).click();
    }

    public void selectNewAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(newAddress)).click();
    }

    public void enterFirstName(String texto){
        wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys(texto);
    }

    public void enterLastname(String texto){
        wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(texto);
    }

    public void enterCompany(String texto){
        wait.until(ExpectedConditions.visibilityOf(company)).sendKeys(texto);
    }

    public void enterAddress1(String texto){
        wait.until(ExpectedConditions.visibilityOf(address_1)).sendKeys(texto);
    }

    public void enterAddress2(String texto){
        wait.until(ExpectedConditions.visibilityOf(address_2)).sendKeys(texto);
    }

    public void enterCity(String texto){
        wait.until(ExpectedConditions.visibilityOf(city)).sendKeys(texto);
    }

    public void enterPostCode(String texto){
        wait.until(ExpectedConditions.visibilityOf(postcode)).sendKeys(texto);
    }

    public void selectCountry(String option){
        Select selectFiltre = new Select(wait.until(ExpectedConditions.visibilityOf(country_id)));
        selectFiltre.selectByValue(option);
    }

    public void selectRegion(String option){
        Select selectFiltre = new Select(wait.until(ExpectedConditions.visibilityOf(region)));
        selectFiltre.selectByValue(option);
    }

    public void clickShippingButton(){
        wait.until(ExpectedConditions.elementToBeClickable(shippingButton)).click();
    }

    public void clickShippingMethodButton(){
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodButton)).click();
    }

    public void clickPaymentButton(){
        wait.until(ExpectedConditions.elementToBeClickable(paymentButton)).click();
    }

    public void clickPaymentMethodButton(){
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodButton)).click();
    }


    public void acceptTermsAndConditions(){
        wait.until(ExpectedConditions.elementToBeClickable(termsAndConditions)).click();
    }

    public void confirmButton(){
        wait.until(ExpectedConditions.elementToBeClickable(confirm)).click();
    }

}
