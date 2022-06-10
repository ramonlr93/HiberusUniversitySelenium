package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CheckOutPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckOutPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private CheckOutPage checkOutPage = pf.getCheckOutPage();


    @And("the user click in the Login button")
    public void theUserClickInTheLoginButton() {
        checkOutPage.clickButtonLogin();
    }

    @And("the user press the continue button")
    public void theUserPressTheContinueButton() throws InterruptedException {
        checkOutPage.clickButtonContinue();
    }

    @And("the user press the check Terms and Conditions")
    public void theUserPressTheCheckTermsAndConditions() {
        checkOutPage.clickCheckTermsConditions();
    }

    @And("the user press the confirm button")
    public void theUserPressTheConfirm() {
        checkOutPage.clickButtonConfirm();
    }
}
