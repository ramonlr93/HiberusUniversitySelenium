package opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(id = "input-firstname")
    private WebElement inputFirstName;

    @FindBy(id = "input-lastname")
    private WebElement inputLastName;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-telephone")
    private WebElement inputTelephone;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "input-confirm")
    private WebElement inputConfirmPassword;

    @FindBy(xpath = "//input[@name = 'agree']")
    private WebElement checkAgreeConditions;

    @FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
    private WebElement suscribeYes;

    @FindBy(xpath = "//input[@name = 'newsletter' and @value = '0']")
    private WebElement suscribeNo;

    @FindBy(xpath = "//input[@value = 'Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//p[contains(text(), 'Congratulations!')]")
    private WebElement congratulationsText;

    @FindBy(xpath = "//div[@class = 'alert alert-danger alert-dismissible']")
    private WebElement alertAgreeConditions;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'First Name')]")
    private WebElement alertFirstName;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Last Name')]")
    private WebElement alertSecondName;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'E-Mail')]")
    private WebElement alertEmail;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Telephone')]")
    private WebElement alertTelephone;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Password must be')]")
    private WebElement alertPassword;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Password confirmation')]")
    private WebElement alertConfirmPassword;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void completeForm(String firstName, String lastName, String email, String telephone, String password, String confirmPassword){
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputTelephone.sendKeys(telephone);
        inputPassword.sendKeys(password);
        inputConfirmPassword.sendKeys(confirmPassword);
    }

    public void setCheckAgreeConditions(String privacyPolicy){
        if(privacyPolicy.toLowerCase().equals("yes")) {
            if(!checkAgreeConditions.isSelected()) checkAgreeConditions.click();
        } else{
            if(checkAgreeConditions.isSelected()) checkAgreeConditions.click();
        }
    }

    public void setSuscribe(String suscribe){
        if(suscribe.toLowerCase().equals("yes")) suscribeYes.click();
        else suscribeNo.click();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public boolean congratulationsIsVissible(){
        wait.until(ExpectedConditions.visibilityOf(congratulationsText));
        if(congratulationsText.isDisplayed()) return true;
        else return false;
    }

    public boolean alertOf(String alert){

        boolean bool = false;

        switch (alert.toLowerCase()){
            case "privacypolicy":
                if(alertAgreeConditions.isDisplayed()) bool = true;
                else bool = false;
                break;
            case "firstname":
                if(alertFirstName.isDisplayed()) bool = true;
                else bool = false;
                break;
            case "secondname":
                if(alertSecondName.isDisplayed()) bool = true;
                else bool = false;
                break;
            case "email":
                if(alertEmail.isDisplayed()) bool = true;
                else bool = false;
                break;
            case "telephone":
                if(alertTelephone.isDisplayed()) bool = true;
                else bool = false;
                break;
            case "password":
                if(alertPassword.isDisplayed()) bool = true;
                else bool = false;
                break;
            case "confirmpassword":
                if(alertConfirmPassword.isDisplayed()) bool = true;
                else bool = false;
                break;
            default:
                bool =  false;
        }
        return bool;
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return inputFirstName;
    }
}
