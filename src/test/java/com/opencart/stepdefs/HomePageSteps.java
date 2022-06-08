package com.opencart.stepdefs;

import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.PagesFactory;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps() {
        homePage = PagesFactory.getInstance().getHomePage();
    }

   @And("the user clicks go home button")
    public void theUserClicksGoHomeButton() {
        homePage.goHome();
   }


}
