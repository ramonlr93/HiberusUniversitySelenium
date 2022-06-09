package com.hiberus.university.stepdefs;


import com.hiberus.university.pages.CheckoutPage;
import com.hiberus.university.pages.LaptopsInventoryPage;
import com.hiberus.university.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LaptopsInventoryPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    LaptopsInventoryPage laptopsInventoryPage = pf.getLaptopsInventoryPage();

    @And("the user clicks the laptops inventory")
    public void clickLaptopsInventory() {
        laptopsInventoryPage.clickLaptopsInventory();
    }

    @Then("the user see the inventory list with 5 items")
    public void inventoryLaptopsNumber() {
        Assert.assertEquals("The number of the laptops inventory isnt correct ", 5, laptopsInventoryPage.getLaptopsList().size());
    }

    @Then("the user see the {string} in the inventory list")
    public void inventoryItemContains(String laptopName) {
        Assert.assertTrue("This laptop isnt in the inventory list ", laptopsInventoryPage.isLaptopContains(laptopName));
    }

    @When("the user add {int} random laptops")
    public void addRandomLaptopsToTheCart(int number) {
        laptopsInventoryPage.clickOnRandomLaptop(number);
    }

    @Then("the user see a success message")
    public void successMessageDisplayed() {
        log.info("The user should be shown an success message");
        Assert.assertTrue("The success message isnt displayed", laptopsInventoryPage.hasSuccessMessageLaptopInventory());
    }

    @And("the user clicks the shopping cart icon")
    public void clicksShoppingCart() throws InterruptedException {
        Thread.sleep(2000); //Se añade tiempo de espera, debido a que el navegador debe recargar la pagina.
        laptopsInventoryPage.clickShoppingCart();
    }

    @When("the user clicks the checkout link")
    public void clickCheckoutButton() throws InterruptedException {
        Thread.sleep(2000); //Se añade tiempo de espera, debido a que el navegador debe recargar la pagina.
        laptopsInventoryPage.checkoutLink();
    }

    @Then("The user is in the checkout page")
    public void theUserInCheckoutPage() throws InterruptedException {
        Thread.sleep(2000); //Se añade tiempo de espera, debido a que el navegador debe recargar la pagina.
        Assert.assertEquals("Step failed", CheckoutPage.PAGE_URL, pf.getDriver().getCurrentUrl());
    }

}
