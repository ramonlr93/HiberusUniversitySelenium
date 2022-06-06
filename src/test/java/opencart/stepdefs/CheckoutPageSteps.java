package opencart.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import opencart.pages.CheckoutPage;
import opencart.pages.LoginPage;
import opencart.pages.PagesFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPageSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private CheckoutPage checkoutPage = pf.getCheckoutPage();
    private WebDriver driver = pf.getDriver();

    @And("The user is on checkout page")
    public void userIsOnCheckoutPage(){
        checkoutPage.waitPage();
        Assert.assertEquals("The user is not on login page", checkoutPage.PAGE_URL, driver.getCurrentUrl());
    }

    @And("the user clicks guest checkout")
    public void theUserClicksGuestCheckout() {
        checkoutPage.clickGuestCheckout();
    }

    @And("the user clicks continue in step {int}")
    public void theUserClicksContinueInStep(int step) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        checkoutPage.clickContinueButtonByStep(step, js);
    }

    @And("the user complete the form with first name {string} last name {string} email {string} telephone {string} address1 {string} city {string} post code {string} country Spain option and region or state Almeria option")
    public void theUserCompleteTheFormWithFirstNameLastNameEmailTelephoneAddressCityPostCodeCountrySpainOptionAndRegionOrStateAlmeriaOption(String name, String lastname, String email, String telephone, String address1, String city, String postCode) {
        checkoutPage.completeSecondStepForm(name, lastname, email, telephone, address1, city, postCode);
    }

    @And("the user clicks check of that delivery and billing addresses are the same")
    public void theUserClicksCheckOfThatDeliveryAndBillingAddressesAreTheSame() {
        checkoutPage.clickDeliviryAndAddressesAreTheSameCheck();
    }

    @And("the user clicks flat shipping")
    public void theUserClicksFlatShipping() {
        checkoutPage.clickFlatShippingRateRadioButton();
    }

    @And("the user clicks cash on delivery option")
    public void theUserClicksCashOnDeliveryOption() {
        checkoutPage.clickCashOnDeliveryRadioButton();
    }

    @And("the user accepts check of terms and conditions")
    public void theUserAcceptsCheckOfTermsAndConditions() {
        checkoutPage.clickTermsAndConditionsCheck();
    }

    @When("the user clicks confirm order button")
    public void theUserClicksConfirmOrderButton(){
        checkoutPage.clickConfirmOrderButton();
    }

    @Then("the user is on checkout success page")
    public void theUserIsOnCheckoutSuccessPage() {
        checkoutPage.waitSuccessPage();
        Assert.assertEquals("The user is not on login page", checkoutPage.PAGE_URL_SUCCESS_CHECKOUT, driver.getCurrentUrl());
    }
}
