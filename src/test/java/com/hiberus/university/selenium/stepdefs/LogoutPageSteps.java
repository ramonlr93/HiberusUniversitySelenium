package com.hiberus.university.selenium.stepdefs;


import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LogoutPageSteps {

    @When("the user is clicks the logout link")
    public void theUserIsClicksTheLogoutLink() {
        PagesFactory pf = PagesFactory.getInstance();
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.openMenu();
        inventoryPage.clickLogout();
    }

    @Then("the user is logout successfully")
    public void theUserIsLogoutSuccessfully() {
        String currentURL = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("PRUEBA FALLIDA - El logout es fallido porque no estamos en la url del login",
                LoginPage.PAGE_URL, currentURL);
    }
}
