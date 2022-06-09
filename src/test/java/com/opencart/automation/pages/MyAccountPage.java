package com.opencart.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "/html/body/div[2]/ul/li[1]")
    private WebElement homeButton;

    @FindBy(xpath = "//html/body/div[1]/nav/div[2]/ul/li[7]/a")
    private WebElement navCameras;

    @FindBy (xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logoutButton;

   @Override
    public WebElement getPageLoadedTestElement() {
        return homeButton;
    }

    public void clickOnHomeButton(){
        click(homeButton);
    }

    public void clickNavCameras(){
       click(navCameras);
    }

    public void clickOnLogout(){
        click(logoutButton);
    }


}
