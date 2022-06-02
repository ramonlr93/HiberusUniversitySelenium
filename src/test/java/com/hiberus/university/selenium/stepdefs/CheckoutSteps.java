package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CheckOutStepOnePage;
import com.hiberus.university.selenium.pages.CheckOutStepTwoPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CheckoutSteps {

    @And("the user provides the first name as {string} and last name as {string} and zip code as {string}")
    public void theUserProvidesTheFirstNameAsAndLastNameAsAndZipCodeAs(String name, String lastName, String zipCode) {
        log.info("the user provides the first checkout info");

        CheckOutStepOnePage page = PagesFactory.getInstance().getCheckOutStepOnePage();
        page.enterFirstName(name);
        page.enterLastName(lastName);
        page.enterPostalCode(zipCode);
    }

    @And("the user clicks continue")
    public void theUserClicksContinue() {
        log.info("the user clicks 'Continue'");

        CheckOutStepOnePage page = PagesFactory.getInstance().getCheckOutStepOnePage();
        page.clickContinue();
    }

    @Then("the user validates prices in checkout summary")
    public void theUserValidatesPricesInCheckoutSummary() {
        CheckOutStepTwoPage page = PagesFactory.getInstance().getCheckOutStepTwoPage();
        List<WebElement> listPriceProducts = page.getCheckoutItemPriceList();
        List<Double> pricesProducts = new ArrayList<>();
        for (WebElement webElement : listPriceProducts) {
            pricesProducts.add(Double.parseDouble(webElement.getText().replace("$", "").trim()));
        }
        double value = 0;
        for (Double pricesProduct : pricesProducts) {
            value += pricesProduct;
        }
        String totalValueActual = page.getItemTotal();
        Assert.assertTrue("the total price is not correct",
                totalValueActual.contains(String.valueOf(value)));
    }
}
