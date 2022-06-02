package com.hiberus.university.selenium.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

public class CheckoutPageSteps {
    @And("the user selects the items")
    public void theUserSelectsTheItems(DataTable dataTable) {
        for (String item : dataTable.asList(String.class)) {
            inventoryPage.addItemToCartByName(item);
        }
    }

}
