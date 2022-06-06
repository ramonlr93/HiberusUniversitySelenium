package opencart.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopButtons extends BasePage {

    @FindBy(xpath = "//span[text() = 'My Account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu dropdown-menu-right']//child:: a[text() = 'Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu dropdown-menu-right']//child:: a[text() = 'Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text() = 'Phones & PDAs']")
    private WebElement phonesAndPdasButton;

    public TopButtons(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return myAccountButton;
    }

    public void clickMyAccountButton(){
        myAccountButton.click();
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickPhonesAndPdasButton(){
        phonesAndPdasButton.click();
    }
}
