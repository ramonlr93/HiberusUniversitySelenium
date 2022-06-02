package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.BasePage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;

public class LogoutPageSteps {

    private static LoginPage loginPage = PagesFactory.getInstance().getLoginPage();

    @And("the user clicks option menu")
    public void theUserClicksOptionMenu() {
        BasePage.openMenu();
    }


    @And("the user clicks logout button")
    public void theUserClicksLogoutButton() {
        BasePage.clickLogout();
    }
}