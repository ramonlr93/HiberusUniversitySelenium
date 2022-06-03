package es.david.practica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends AbstractPage{

    @FindBy(id = "input-firstname")
    private WebElement firstnameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastnameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement phoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(id = "input-confirm")
    private WebElement confirmInput;

    @FindBy(xpath = "//input[contains(@name, 'agree')]")
    private WebElement policyCheck;

    @FindBy(xpath = "//input[contains(@value, 'Continue')]")
    private WebElement registerButton;

    RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void enterName(String name){
        wait.until(ExpectedConditions.visibilityOf(firstnameInput)).sendKeys(name);
    }

    public void enterLastname(String lastname){
        wait.until(ExpectedConditions.visibilityOf(lastnameInput)).sendKeys(lastname);
    }

    public void enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
    }

    public void enterPhone(String phone){
        wait.until(ExpectedConditions.visibilityOf(phoneInput)).sendKeys(phone);
    }

    public void enterPassword(String pass){
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(pass);
    }

    public void enterConfirmPassword(String pass){
        wait.until(ExpectedConditions.visibilityOf(confirmInput)).sendKeys(pass);
    }

    public void acceptPoticy(){
        wait.until(ExpectedConditions.visibilityOf(policyCheck)).click();
    }

    public void clickRegister(){
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }
}
