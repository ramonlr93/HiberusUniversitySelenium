package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CheckOutCompletePage;
import com.hiberus.university.selenium.pages.CheckOutStepOnePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
@Slf4j
public class CheckOutStepCompletePageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private CheckOutCompletePage checkOutCompletePage = pf.getCheckOutCompletePage();

    @Then("the user can see the message {string}")
    public void theUserCanSeeTheMessage(String message) {
        Assert.assertEquals("TEXTO ERRONEO.",message,checkOutCompletePage.getFinalText());
    }
}
