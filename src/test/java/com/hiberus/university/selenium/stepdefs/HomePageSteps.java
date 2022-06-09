package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
//import sun.jvm.hotspot.debugger.Page;

@Slf4j
public class HomePageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    HomePage hp = pf.getHomePage();


    @Given("the user is on the home page actual")
    public void theUserIsOnTheHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the Home Page");
        HomePage homePage = pf.getHomePage();
        homePage.navigateTo(HomePage.PAGE_URL);
    }

    @And("the user clicks MyAccount")
    public void myAccount() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the Home Page");
        HomePage homePage = pf.getHomePage();
        homePage.clickMyAccount();
    }

    @And("the user selects the login")
    public void Login() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user click on Login");
        HomePage homePage = pf.getHomePage();
        homePage.clickLogin();
    }

    @And("the user selects register")
    public void Register() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user click in Register");
        HomePage homePage = pf.getHomePage();
        homePage.clickRegister();

    }

    //Esto es del inventory page de Jonatan
    @Then("the items in the featured are {string}")
    public void theUserSeeTheInventoryListWith(String itemSize) {
        log.info("the user see the item list");
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage = pf.getHomePage();
        Assert.assertEquals("the item list size is different", Integer.parseInt(itemSize),
                homePage.getInventoryNameList().size());
    }

    @When("the user adds an item by clicking 'Add To Cart'")
    public void theUserAddsAByClickingAddToCart() {
        log.info("the user adds by 'Add To Cart'");
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage = pf.getHomePage();
        homePage.addItemToCart();
    }

    @And("the user see the success alert")
    public void theUserCanSeeTheSuccessAlert() {
        log.info("the user can see the succes alert");
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage = pf.getHomePage();
        Assert.assertTrue(homePage.theItemIsInTheCart());
    }

    @Then("there should be an item in the cart")
    public void anItemExistsInTheCart() {
        log.info("there is an item in the cart");
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage = pf.getHomePage();
        Assert.assertNotNull("The user can see the cart with one item", homePage.cartInfo());
    }
}










