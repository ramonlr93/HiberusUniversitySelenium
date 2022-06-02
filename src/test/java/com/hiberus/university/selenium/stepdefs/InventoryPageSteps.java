package com.hiberus.university.selenium.stepdefs;


import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class InventoryPageSteps {
    PagesFactory pf = PagesFactory.getInstance();

    @Then("the items count is equal {int}")
    public void theItemsCountIsEqual(int itemNumber) {
        log.info("The user is on the inventory page");
        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertEquals("PRUEBA FALLIDA - Los productos no son los esperados",
                itemNumber, inventoryPage.getInventoryContainerSize());
    }

    @Then("the {string} product is present on the inventory page")
    public void theProductIsPresentOnTheInventoryPage(String product) {
        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertTrue("PRUEBA FALLIDA - El producto esperado no aparece",
                inventoryPage.itemPresentByName(product));
    }

    @When("the {string} product add to cart")
    public void theProductAddToCart(String product) {
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.getButtonByName(product, "add");
    }

    @Then("the cart icon has increased to {int}")
    public void theCartIconHasIncreasedTo(int cartIconNum) {
        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertEquals("PRUEBA FALLIDA - La cantidad en el carrito no es la esperada",
                cartIconNum, inventoryPage.getNumberInCart());
    }

    @When("the {string} product is remove")
    public void theProtuctIsRemove(String product) {
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.getButtonByName(product, "remove");
    }

    @Then("the cart icon has not increased")
    public void theCartIconHasNotIncreased() {
        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertTrue("PRUEBA FALLIDA - El producto no se ha eliminado", inventoryPage.cartIsPresent());
    }

    @When("the {int} products random add to cart")
    public void theProductsAddToCart(int itemNumber) {
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.getRandomAndClick(itemNumber, "add");
    }

    @When("select the filter {string}")
    public void selectTheFilter(String filter) {
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.sortSelectOption(filter);
    }

    @Then("see the list by name is order correctly")
    public void seethelistbyname() {
        InventoryPage inventoryPage = pf.getInventoryPage();
        List<String> OrderExpected= new ArrayList<>();
        List<String> OrderObtained= new ArrayList<>();

        OrderExpected= inventoryPage.getItemNameList();
        OrderObtained = inventoryPage.getItemNameList();
        OrderExpected.sort(Collections.reverseOrder());

        Assert.assertEquals("PRUEBA FALLIDA - El filtro seleccionado no funiona correctamente",
              OrderExpected  , OrderObtained);
    }

    @Then("see the list by price is order correctly")
    public void seethelistbyprice() {
        InventoryPage inventoryPage = pf.getInventoryPage();
        List<Float> OrderExpected= new ArrayList<>();
        List<Float> OrderObtained= new ArrayList<>();

        OrderExpected= inventoryPage.getItemPriceList();
        OrderObtained = inventoryPage.getItemPriceList();
        OrderExpected.sort(Collections.reverseOrder());

        Assert.assertEquals("PRUEBA FALLIDA - El filtro seleccionado no funiona correctamente",
                OrderExpected  , OrderObtained);
    }

}
