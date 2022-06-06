package opencart.stepdefs;

import io.cucumber.java.en.And;
import opencart.pages.HomePage;
import opencart.pages.PagesFactory;
import opencart.pages.TopButtons;

public class TopButtonsSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private TopButtons topButtons = pf.getTopButtons();

    @And("the user selects -My Account-")
    public void selectMyAccount(){
        topButtons.clickMyAccountButton();
    }

    @And("the user selects -Register-")
    public void theUserSelectsRegister() {
        topButtons.clickRegisterButton();
    }

    @And("the user selects -Login-")
    public void theUserSelectsLogin() {
        topButtons.clickLoginButton();
    }

    @And("The user clicks phones and pdas button")
    public void theUserClicksPhonesAndPdasButton() {
        topButtons.clickPhonesAndPdasButton();
    }
}
