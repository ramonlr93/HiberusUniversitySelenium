package opencart.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopButtons extends BasePage {

    @FindBy(xpath = "//span[text() = 'My Account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu dropdown-menu-right']//child:: a[text() = 'Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu dropdown-menu-right']//child:: a[text() = 'Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text() = 'Phones & PDAs']")
    private WebElement phonesAndPdasButton;

    @FindBy(xpath = "//div[@id = 'top-links']//descendant::a[text() = 'Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//span[@class = 'hidden-xs hidden-sm hidden-md' and text() = 'Checkout']")
    private WebElement checkoutButton;

    public TopButtons(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return myAccountButton;
    }

    public void clickMyAccountButton(){
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton)).click();
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void clickPhonesAndPdasButton(){
        phonesAndPdasButton.click();
    }

    public void clickLogoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void clickCheckoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
