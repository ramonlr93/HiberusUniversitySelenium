package com.practicafinal.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {

  @FindBy(id = "input-email")
  private WebElement emailInput;

  @FindBy(id = "input-password")
  private WebElement passwordInput;

  @FindBy(xpath = "//input[@type='submit']")
  private WebElement loginButton;

  @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
  private WebElement errorMessageLogin;

  @FindBy(xpath = "//a[text()='Forgotten Password']")
  private WebElement labelForgottenPass;

  @FindBy(xpath = "//input[@type='submit' and @value='Continue']")
  private WebElement sendPassReset;

  @FindBy(xpath = "//div[text()=' An email with a confirmation link has been sent your email address.']")
  private WebElement infoMessage;

  public LoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return loginButton;
  }

  public void clickLogin() {
    log.info("Logging in...");
    try {
      loginButton.click();
    } catch (org.openqa.selenium.TimeoutException e) {
      log.info("Timeout clicking login: " + e.getClass().getSimpleName());

    } catch (Exception e) {
      log.info("Clicking login, caught exception, type=" + e.getClass().getSimpleName());
    }
  }

  public void fillLoginForm(String email, String password){
    emailInput.click();
    emailInput.sendKeys(email);
    passwordInput.click();
    passwordInput.sendKeys(password);
  }

  public boolean errorIsShown(){
    return errorMessageLogin.isDisplayed();
  }

  public void forgotPass(){
    labelForgottenPass.click();
  }

  public void enterEmail(String email){
    emailInput.click();
    emailInput.sendKeys(email);
    sendPassReset.click();

  }
  public boolean infoMeessageIsShown(){
    return infoMessage.isDisplayed();
  }


}
