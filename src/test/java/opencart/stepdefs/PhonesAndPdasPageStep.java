package opencart.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import opencart.pages.PagesFactory;
import opencart.pages.PhonesAndPdasPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PhonesAndPdasPageStep {

    private PagesFactory pf = PagesFactory.getInstance();
    private PhonesAndPdasPage phonesAndPdasPage = pf.getPhonesAndPdasPage();
    private WebDriver driver = pf.getDriver();

    @And("the user is on phones and pdas page")
    public void theUserIsOnPhoneAndPdasPage(){
        Assert.assertEquals("The user is not on phones and pdas page", phonesAndPdasPage.PAGE_URL, driver.getCurrentUrl());
    }

    @When("the user add {int} item to cart")
    public void theUserAddItemToCart(int number) {
        phonesAndPdasPage.addToCartRandomByNumber(number);
    }

    @When("the user add an item {int} times to cart")
    public void theUserAddAnItemTimesToCart(int number) {
        phonesAndPdasPage.addTheFirstProductManyTimes(number);
    }

    @Then("The user can see {int} item in the cart button")
    public void theUserCanSeeItemInTheCartButton(int number) {
        Assert.assertTrue("The user cant see the item number in the cart button", phonesAndPdasPage.cartTextContainsNumber(number));
    }

    @And("The user clicks cart button")
    public void theUserClicksCartButton() {
        phonesAndPdasPage.clickCartButton();
    }

    @Then("The user can see the product is x{int}")
    public void theUserCanSeeTheProductIsX(int number) {
        Assert.assertTrue("Number is not x" + number, phonesAndPdasPage.getSameFirstProducts(number));
    }

    @And("The user remove the item")
    public void theUserRemoveTheItem() {
        phonesAndPdasPage.removeFirstItem();
    }

    @And("the user add the first product to the cart")
    public void theUserAddTheFirstProductToTheCart() {
        phonesAndPdasPage.addTheFirstProductManyTimes(1);
    }

}
