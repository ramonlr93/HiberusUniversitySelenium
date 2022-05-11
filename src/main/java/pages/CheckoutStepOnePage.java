package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class CheckoutStepOnePage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-one.html";

    @FindBy(id = "first-name")
    private WebElement nameInput;

    @FindBy(id = "last-name")
    private WebElement surnameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement errorMsjDiv;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "cancel")
    private WebElement cancelBtn;

    CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void fillNameInput(String data) {
        nameInput.sendKeys(data);
    }

    public void fillSurnameInput(String data) {
        surnameInput.sendKeys(data);
    }

    public void fillPostalCodeInput(String data) {
        postalCodeInput.sendKeys(data);
    }

    public boolean isErrorMsjDivDisplayed() {
        return errorMsjDiv.isDisplayed();
    }

    public String getErrorMsjDivText() {
        return isErrorMsjDivDisplayed() ? errorMsjDiv.getText() : "Element not displayed";
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    public void clickCancelBtn() {
        cancelBtn.click();
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

}
