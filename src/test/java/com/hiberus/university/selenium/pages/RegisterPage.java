package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RegisterPage extends BasePage {
  public static final String REGISTER_URL = "https://opencart.abstracta.us/index.php?route=account/register";
  public static final String REGISTER_SUCCESS_URL = "http://opencart.abstracta.us/index.php?route=account/success";

  @FindBy(xpath = "//*[@id=\"input-firstname\"]")
  private WebElement firstNameInput;

  @FindBy(xpath = "//*[@id=\"input-lastname\"]")
  private WebElement lastNameInput;

  @FindBy(xpath = "//*[@id=\"input-email\"]")
  private WebElement emailInput;

  @FindBy(xpath = "//*[@id=\"input-telephone\"]")
  private WebElement telephoneInput;

  @FindBy(xpath = "//*[@id=\"input-password\"]")
  private WebElement passwordInput;

  @FindBy(xpath = "//*[@id=\"input-confirm\"]")
  private WebElement passwordConfirmInput;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
  private WebElement privacyPolicyCheck;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
  private WebElement continueButton;

  @FindBy(xpath = "//*[@id=\"content\"]/p/a")
  private WebElement loginPageLink;

  @FindBy(xpath = "//*[@id=\"account\"]/div[2]/div/div")
  private WebElement firstNameError;

  @FindBy(xpath = "//*[@id=\"account\"]/div[3]/div/div")
  private WebElement lastNameError;

  @FindBy(xpath = "//*[@id=\"input-email\"]")
  private WebElement emailError;

  @FindBy(xpath = "//*[@id=\"account\"]/div[5]/div/div")
  private WebElement telephoneError;

  @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")
  private WebElement passwordError;

  @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div")
  private WebElement passwordNotMatchError;

  @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")
  private WebElement emailAlreadyInUseError;

  @FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
  private WebElement privacyPolicyNotAgreedError;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
  private WebElement successContinueButton;



  public RegisterPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return firstNameInput;
  }

  public void fillRegister(String firstName, String lastName, String email, String telephone, String password, String passwordConfirm) {
    try {
      firstNameInput.click();
      firstNameInput.sendKeys(firstName);

      lastNameInput.click();
      lastNameInput.sendKeys(lastName);

      emailInput.click();
      emailInput.sendKeys(email);

      telephoneInput.click();
      telephoneInput.sendKeys(telephone);

      passwordInput.click();
      passwordInput.sendKeys(password);

      passwordConfirmInput.click();
      passwordConfirmInput.sendKeys(passwordConfirm);
    } catch (org.openqa.selenium.TimeoutException e) {
    } catch (Exception e) {
    }
  }

  public void acceptPrivacyPolicy() {
    privacyPolicyCheck.click();
  }

  public void clickContinueButton() {
    continueButton.click();
  }

  public boolean hasErrorInField(String fieldWithError) {
    switch (fieldWithError) {
      case "firstName":
        System.out.println("Error in " + fieldWithError);
        return firstNameError.isDisplayed();

      case "lastName":
        System.out.println("Error in " + fieldWithError);
        return lastNameError.isDisplayed();

      case "email":
        System.out.println("Error in " + fieldWithError);
        return emailError.isDisplayed();

      case "telephone":
        System.out.println("Error in " + fieldWithError);
        return telephoneError.isDisplayed();

      case "password":
        System.out.println("Error in " + fieldWithError);
        return passwordError.isDisplayed();

      default:
        return false;
    }
  }

  public boolean errorsShown(){
    boolean firstNameError = hasErrorInField("firstName");
    boolean lastNameError = hasErrorInField("lastName");
    boolean emailError = hasErrorInField("email");
    boolean telephoneError = hasErrorInField("telephone");
    boolean passwordError = hasErrorInField("password");
    return firstNameError&&lastNameError&&emailError&&telephoneError&&passwordError;
  }

  public boolean hasPasswordNotMatchError() {
    getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    try {
      return passwordNotMatchError.isDisplayed();
    } catch (org.openqa.selenium.TimeoutException e) {
      log.info("Timeout clicking login: " + e.getClass().getSimpleName());
    }
    return false;
  }
  public boolean hasEmailAlreadyRegisteredError() {
    getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    try {
      return emailError.isDisplayed();
    } catch (org.openqa.selenium.TimeoutException e) {
      log.info("Timeout clicking login: " + e.getClass().getSimpleName());
    }
    return false;
  }

  public boolean hasPrivacyPolicyNotAgreedError() {
    getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    try {
      return !privacyPolicyCheck.isSelected();
    } catch (org.openqa.selenium.TimeoutException e) {
      log.info("Timeout clicking login: " + e.getClass().getSimpleName());
    }
    return false;
  }

  private void clickButton (WebElement webelementToClick) {
    webelementToClick.click();
  }

  public void clickOnLoginPageLink(){
    clickButton(loginPageLink);
  }

  public void waitTillRegisterSuccess(){
    getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
      successContinueButton.isDisplayed();
    } catch (org.openqa.selenium.TimeoutException e) {
    } catch (Exception e) {
    }
  }
}
