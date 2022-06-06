package opencart.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class CheckoutPage extends BasePage {

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";
    public static final String PAGE_URL_SUCCESS_CHECKOUT = "http://opencart.abstracta.us/index.php?route=checkout/success";

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement checkoutInfo;

    @FindBy(xpath = "///*[@id='content']/h1[contains(text(), 'Your order has been placed')]")
    private WebElement orderHasBeenPlacedText;

    @FindBy(xpath = "//*[@id='collapse-checkout-option']/div/div/div[1]/div[2]/label/input")
    private WebElement guestCheckoutRadioButton;

    @FindBy(id = "button-account")
    private WebElement continueButtonFirstStep;

    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameText;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameText;

    @FindBy(id = "input-payment-email")
    private WebElement emailText;

    @FindBy(id = "input-payment-telephone")
    private WebElement telephoneText;

    @FindBy(id = "input-payment-address-1")
    private WebElement addres1Text;

    @FindBy(id = "input-payment-city")
    private WebElement cityText;

    @FindBy(id = "input-payment-postcode")
    private WebElement postCodeText;

    @FindBy(id = "input-payment-country")
    private WebElement countryOption;

    @FindBy(id = "input-payment-zone")
    private WebElement regionStateOption;

    @FindBy(xpath = "//*[@id='collapse-payment-address']/div/div[2]/label/input")
    private WebElement deliveryBillingAddressesSameCheck;

    @FindBy(id = "button-guest")
    private WebElement continueButtonSecondStep;

    @FindBy(xpath = "//*[@id='collapse-shipping-method']/div/div[1]/label/input")
    private WebElement flatShippingRateRadioButton;

    @FindBy(id = "button-shipping-method")
    private WebElement continueButtonThirdStep;

    @FindBy(xpath = "//*[@id='collapse-payment-method']/div/div[2]/label/input")
    private WebElement cashOnDeliveryRadioButton;

    @FindBy(xpath = "//*[@id='collapse-payment-method']/div/div[3]/div/input[1]")
    private WebElement termsAndConditionsCheck;

    @FindBy(id = "button-payment-method")
    private WebElement continueButtonfourthStep;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//*[@id='input-payment-country']/option[209]")
    private WebElement spainCountryOption;

    @FindBy(xpath = "//*[@id='input-payment-zone']/option[6]")
    private WebElement almeriaRegionStateOption;

    


    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return checkoutInfo;
    }

    public void clickGuestCheckout(){
        guestCheckoutRadioButton.click();
    }

    public void clickContinueButtonByStep(int number, JavascriptExecutor js){
        switch (number){
            case 1:
                wait.until(ExpectedConditions.elementToBeClickable(continueButtonFirstStep)).click();
                break;
            case 2:
                js.executeScript("window.scrollBy(0,1000)");
                continueButtonSecondStep.click();
                break;
            case 3:
                continueButtonThirdStep.click();
                break;
            case 4:
                continueButtonfourthStep.click();
                break;
            default:
                log.info("number of step in continue button is incorrect");
                break;
        }
    }

    public void completeSecondStepForm(String name, String lastname, String email, String telephone, String address1, String city, String postCode){
        firstNameText.sendKeys(name);
        lastNameText.sendKeys(lastname);
        emailText.sendKeys(email);
        telephoneText.sendKeys(telephone);
        addres1Text.sendKeys(address1);
        cityText.sendKeys(city);
        postCodeText.sendKeys(postCode);

        countryOption.click();
        spainCountryOption.click();
        regionStateOption.click();
        almeriaRegionStateOption.click();
    }

    public void clickDeliviryAndAddressesAreTheSameCheck(){
        if(!deliveryBillingAddressesSameCheck.isSelected()) deliveryBillingAddressesSameCheck.click();
    }

    public void clickFlatShippingRateRadioButton(){
        flatShippingRateRadioButton.click();
    }

    public void clickCashOnDeliveryRadioButton(){
        cashOnDeliveryRadioButton.click();
    }

    public void clickTermsAndConditionsCheck(){
        if(!termsAndConditionsCheck.isSelected()) termsAndConditionsCheck.click();
    }

    public void clickConfirmOrderButton(){
        confirmOrderButton.click();
    }

    public void waitPage(){
        wait.until(ExpectedConditions.visibilityOf(checkoutInfo));
    }

    public void waitSuccessPage(){
        wait.until(ExpectedConditions.visibilityOf(orderHasBeenPlacedText));
    }
}
