package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CartPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    LoginPage loginPage = pf.getLoginPage();
    InventoryPage inventoryPage = pf.getInventoryPage();
    CartPage cartPage = pf.getCartPage();

    @And("the user clicks the cart button")
    public void clickShoppingCart(){
        inventoryPage.clickOnShoppingCart();
    }

    @When("the user deletes 1 item in the cart by {int}")
    public void deleteCarItemtByPos(int position){
        cartPage.deleteCarItemtByPosition(position);
    }

    @Then("the user cant see the item in the {int}")
    public void validateDeleteItemByPosition(int position){
        Assert.assertFalse("EL PRODUCTO QUE SE DESEABA ELIMINAR, SE HA ELIMINADO DEL CARRITO", cartPage.cartItemByName().get(position).isEmpty());
    }


}
