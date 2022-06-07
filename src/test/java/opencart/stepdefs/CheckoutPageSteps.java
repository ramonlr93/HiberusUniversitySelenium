package opencart.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import opencart.pages.CheckoutPage;
import opencart.pages.PagesFactory;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CheckoutPageSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private CheckoutPage checkoutPage = pf.getCheckoutPage();
    private WebDriver driver = pf.getDriver();
    private JavascriptExecutor js = (JavascriptExecutor) driver;

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
        checkoutPage.completeSecondStepForm(name, lastname, email, telephone, address1, city, postCode, js);
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
        Assert.assertTrue("The user is not on login page", checkoutPage.orderHasBeenPlacedVisible());
    }

    @When("the user clicks continue button in step {int}")
    public void theUserClicksContinueButtonInStep(int step) {
        checkoutPage.clickContinueButtonByStep(step, js);
    }

    @Then("the user can see an alert")
    public void theUserCanSeeAnAlert(DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        for(String e:list) {
            Assert.assertTrue("The alert " + e + " is not visible.", checkoutPage.isAlertVisible(e));
        }
    }

    @And("click country -please select- and region state -please select-")
    public void clickCountryPleaseSelectAndRegionStatePleaseSelect() {
        checkoutPage.pleaseSelectCountryAndRegionState(js);
    }

    @Then("the user can see a warning")
    public void theUserCanSeeAWarning() {
        Assert.assertTrue("The warning about accept permisions is not visible", checkoutPage.isWarningPermissionsStep5Visible());
    }
}
