package com.opencart.automation.stepdefs;

import com.opencart.automation.pages.BasePage;
import com.opencart.automation.pages.CheckoutPage;
import com.opencart.automation.pages.MyAccountPage;
import com.opencart.automation.pages.PagesFactory;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class CheckoutPageSteps {
    private final PagesFactory pf = PagesFactory.getInstance();
    private final MyAccountPage myAccountPage;
    private final WebDriver driver = pf.getDriver();

    public CheckoutPageSteps() {
        myAccountPage = PagesFactory.getInstance().getMyAccountPage();
        CheckoutPage checkoutPage = PagesFactory.getInstance().getCheckoutPage();
    }



    @And("the user go checkout")
    public void theUserGoToCheckout(){
        myAccountPage.clickOnCheckout();
    }


    }

