package org.example.tests.POM.orangeHRM;

import org.example.base.CommonToAllTest;
import org.example.pages.pageObjectModel.OrangeHRM.EmployeeListHomePage;
import org.example.pages.pageObjectModel.OrangeHRM.LoginPageOrangeHRM_POM;
import org.example.Utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.Assert;


import static org.example.Driver.DriverManager.getDriver;

public class TestOrangeHR_POM  extends CommonToAllTest {

    @Owner("PRAMOD")
    @Description("Verify that the login to the OrangeHR ")
    @Test
    public void testLoginPositive() {


        LoginPageOrangeHRM_POM loginHRPage = new LoginPageOrangeHRM_POM(getDriver());
        loginHRPage.loginToHRCreds(PropertiesReader.readKey("ohr_username"),PropertiesReader.readKey("ohr_password"));

        EmployeeListHomePage dashboardPagePom = new EmployeeListHomePage(getDriver());
        String loggedInUserName = dashboardPagePom.loggedInUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName,PropertiesReader.readKey("ohr_expected_username"));


    }
}