package com.hiberus.university.selenium.stepdefs;


import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.List;

@Slf4j
public class InventoryPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();

    @Then("the items count on feature is equal {int}")
    public void theItemsCountIsEqual(int itemNumber) {
        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertEquals("PRUEBA FALLIDA - Los productos no son los esperados",
                itemNumber, inventoryPage.getFeatureContainerSize());
}
    @When("the user add product to cart")
    public void theProductAddToCart(DataTable products) {
        InventoryPage inventoryPage = pf.getInventoryPage();
        List<String> productList = products.asList(String.class);
        for (String product : productList){
            inventoryPage.getAddToCartByName(product);
        }
    }

    @Then("show the ok message add to cart product")
    public void showTheOkMessageAddToCartProduct() {
        InventoryPage inventoryPage = pf.getInventoryPage();
        Assert.assertTrue("ok message not found", inventoryPage.hasOkAddToCartProduct());
    }
}
