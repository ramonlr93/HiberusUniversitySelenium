package es.david.practica.stepdefs;

import es.david.practica.pages.BasePage;
import es.david.practica.pages.CartPage;
import es.david.practica.pages.HomePage;
import es.david.practica.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;


@Slf4j
public class HomePageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    BasePage bp = pf.getBasePage();
    HomePage hp = pf.getHomePage();
    CartPage cp = pf.getCartPage();

    @When("the user can see the featured section")
    public void canSeeFeaturedSecion() {
        Assert.assertTrue("Can't see featured section", hp.isFeaturedDisplayed());
    }

    @Then("the number of items is {int}")
    public void checkNumberOfProducts(int size) {
        Assert.assertEquals("Can't see featured section", size, hp.getNumberOfProducts());
    }

    @Then("the user can see the carousels {string}")
    public void canSeeCarousels(String options) {
        if(options.toLowerCase().equals("products")){
            Assert.assertTrue("The "+options+" doesn't exist", hp.isProductsCarouselDisplayed());
        } else if (options.toLowerCase().equals("companies")){
            Assert.assertTrue("The "+options+" doesn't exist", hp.isCompaniesCarouselDisplayed());
        }

    }

    @When("the user adds all items to the cart")
    public void addAllItemsToCart() throws InterruptedException {
        hp.addItemsToCart();
    }

    @And("the user goes to cart")
    public void goesToCart() {
        bp.clickShoppingCart();
    }

    @Then("the item should appear in the cart")
    public void checkCartItems() {
        List<String> addedProducts = hp.getItemAddedNames();
        List<String> cartProducts = cp.getItemNames();
        addedProducts.sort(Collections.reverseOrder());
        log.info(addedProducts.toString());
        log.info(cartProducts.toString());
        Assert.assertArrayEquals("Products aren't the same as clicked"
                , addedProducts.toArray()
                , cartProducts.toArray());

    }

    @And("the user goes to home")
    public void theUserGoesToHome() {
        bp.clickYourStoreButton();
    }
}
