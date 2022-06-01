package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.CheckOutStepOnePage;
import com.hiberus.university.selenium.pages.CheckOutStepTwoPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CheckoutPageSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private CheckOutStepOnePage checkOne = pf.getCheckOutStepOnePage();
    private CheckOutStepTwoPage checkTwo = pf.getCheckOutStepTwoPage();

    @And("the user fills the checkout form with the values {string}, {string}, {string}")
    public void theUserFillsTheCheckoutFormWithTheValues(String arg0, String arg1, String arg2) {
        checkOne.enterFirstName(arg0);
        checkOne.enterLastName(arg1);
        checkOne.enterPostalCode(arg2);
    }

    @When("the user continues to the second step")
    public void theUserContinuesToTheSecondStep() {
        checkOne.clickContinue();
    }

    @Then("the total price of the order is the correct")
    public void theTotalPriceOfTheOrderIsTheCorrect() {
        List<String> prices = checkTwo.getPrices();
        float totalPrice=0.0f;
        for(int i =0;i<prices.size();i++){
            String priceItem =  prices.get(i);
            String priceAux = priceItem.substring(1);
            float priceAdd = Float.parseFloat(priceAux);
            totalPrice += priceAdd;
        }
        String totalPriceSumatory = String.valueOf(totalPrice);
        String itemTotal = checkTwo.getItemTotal();
        String itemTotalReplace = itemTotal.substring(13);
        Assert.assertEquals("the prices are not equal", itemTotalReplace, totalPriceSumatory);
    }

}
