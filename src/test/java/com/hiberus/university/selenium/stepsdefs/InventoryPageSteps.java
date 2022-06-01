package com.hiberus.university.selenium.stepsdefs;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import java.util.List;

@Slf4j
public class InventoryPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    InventoryPage inventoryPage = pf.getInventoryPage();
    @When("the user clicks select {string}")
    public void theUserClicksSelect(String optionSort) {
        inventoryPage.selectOption(optionSort);
    }

    @Then("the user see the list by price desc order")
    public void theUserSeeTheListByPriceDescOrder() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();

    }
}