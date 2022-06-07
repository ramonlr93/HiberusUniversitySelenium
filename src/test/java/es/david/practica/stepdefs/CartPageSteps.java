package es.david.practica.stepdefs;

import es.david.practica.pages.CartPage;
import es.david.practica.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CartPageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    CartPage cp = pf.getCartPage();

    @Then("the total price should be the sum of the total of each product")
    public void checkTotalPrice() {
        Assert.assertEquals("Total price isnt the sum of all product prices", cp.getTotalPrice(), cp.getTotalCalculatedPrice());
    }

    @Then("the total price of item in the multiplication between price and quantity")
    public void checkTotalPricePerProduct() {
        Assert.assertEquals("Total price isnt the multiplication between price and quantity"
                , cp.getTotalPricePerProduct()
                , cp.getTotalCalculatedPricePerProduct());
    }

    @When("the user clicks the checkout button")
    public void clickCheckoutButton() {
        cp.clickCheckoutButton();
    }



}
