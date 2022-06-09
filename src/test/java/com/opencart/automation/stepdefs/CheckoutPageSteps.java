package com.opencart.automation.stepdefs;

import com.opencart.automation.pages.BasePage;
import com.opencart.automation.pages.CheckoutPage;
import com.opencart.automation.pages.PagesFactory;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class CheckoutPageSteps {
    private final CheckoutPage checkoutPage;


    public CheckoutPageSteps() {
        checkoutPage = PagesFactory.getInstance().getCheckoutPage();
    }



    }

