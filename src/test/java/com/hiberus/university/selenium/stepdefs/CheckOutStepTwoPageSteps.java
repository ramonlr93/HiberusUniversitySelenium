package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Slf4j
public class CheckOutStepTwoPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();

    private CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();

    @Then("the user can see the item total price")
    public void theUserCanSeeTheItemTotalPrice() {
        Assert.assertEquals("EL PRECIO NO ES EL MISMO.", String.valueOf(pf.getInventoryPage().finalPrice), checkOutStepTwoPage.getItemTotal().replace("Item total: $",""));
    }

    @When("the user clicks on the finish button")
    public void theUserClicksOnTheFinishButton() {
        checkOutStepTwoPage.clickFinishButton();
    }
}
