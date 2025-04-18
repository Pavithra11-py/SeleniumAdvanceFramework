package org.example.pages.pageObjectModel.appvwo;

import org.example.Utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {

    WebDriver driver;

    public void DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


    // Page Actions
    public String loggedInUserName(){
        WaitHelper.waitJVM(10000);
        return driver.findElement(userNameOnDashboard).getText();
    }

}
