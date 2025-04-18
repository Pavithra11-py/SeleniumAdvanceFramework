package org.example.tests.POM;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.pages.pageObjectModel.appvwo.DashBoardPage;
import org.example.pages.pageObjectModel.appvwo.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWO_login_normalscript {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        // Driver Manager Code - 1
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);

        // Page Class Code (POM Code) - 2
        loginPage loginpage  = new loginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCreds("admin@gmail.com","1234");

        // Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

        driver.quit();


    }



    @Owner("Pavi")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void test_positive_vwo_login() {


        WebDriver driver = new EdgeDriver();


        loginPage loginpage_VWO = new loginPage(driver);
        loginpage_VWO.loginToVWOLoginValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");
        DashBoardPage dashBoardPage  = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Aman");
        driver.quit();

    }

}
