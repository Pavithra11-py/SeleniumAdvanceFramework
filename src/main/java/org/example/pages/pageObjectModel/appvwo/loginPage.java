package org.example.pages.pageObjectModel.appvwo;

import org.example.Utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Page class
public class loginPage {

    static WebDriver driver;
    public loginPage(WebDriver driver){

      this.driver = driver;

    }

    // Step 1- Page Locators (always privates)
    private static By username = By.id("login-username");
    private static By password = By.id("login-password");
    private static By signButton = By.id("js-login-btn");
    private static By error_message = By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By singBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");

    // Step 2 - Page Actions

    public static String loginToVWOLoginInvalidCreds(String user, String pwd) {

        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        // Wait - Thread sleep
        WaitHelper.waitJVM(5000);
        // Wait - Explicit Wait
//        WaitHelpers.checkVisibility(driver,error_message);

        String error_message_text = driver.findElement(error_message).getText();
        return error_message_text;


    }

    public void loginToVWOLoginValidCreds(String user, String pwd) {


        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        // Wait - Thread sleep
        WaitHelper.waitJVM(5000);
        // Wait - Explicit Wait
//        WaitHelpers.checkVisibility(driver,error_message);


    }


}