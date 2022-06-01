package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.BasePage;
import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPageSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private LoginPage lp = pf.getLoginPage();

    @And("the user clicks option menu")
    public void theUserClicksOptionMenu(){

        BasePage.openMenu();
    }


    @And("the user clicks logout button")
    public void theUserClicksLogoutButton() {

        BasePage.clickLogout();
    }
}
