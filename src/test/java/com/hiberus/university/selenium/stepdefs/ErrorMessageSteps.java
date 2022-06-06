package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class ErrorMessageSteps {

    @Then("the user sees an error message that says {string}")
    public void theUserSeesAnErrorMessageThatSays(String errorMessage) {
        Assert.assertEquals(
                "El mensaje de error no es el correcto o no esta mostrado",
                errorMessage,
                PagesFactory.getInstance().getHomePage().getErrorMessage()
        );
    }

}
