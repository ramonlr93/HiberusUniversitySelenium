package opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/login";

    @FindBy(xpath = "//a[@class = 'btn btn-primary']")
    private WebElement newCustomerButton;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@class = 'btn btn-primary']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class = 'form-group']//child:: a")
    private WebElement forgottenPasswordButton;

    @FindBy(xpath = "//div[@class = 'alert alert-danger alert-dismissible']")
    private WebElement alert;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return newCustomerButton;
    }

    public void clickNewCustomerButton(){
        newCustomerButton.click();
    }

    public void completeLoginForm(String email, String password){
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public boolean alertIsVissible(){
        wait.until(ExpectedConditions.visibilityOf(alert));
        if(alert.isDisplayed()) return true;
        else return false;
    }

    public void clickForgottenPasswordButton(){
        forgottenPasswordButton.click();
    }
}
