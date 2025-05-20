package org.example.tests.pom.vwo;

import org.example.Base.CommonToAllTest;
import org.example.listeners.RetryAnalyzer;
import org.example.listeners.ScreenshotListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;

import static org.example.Driver.DriverManager.getDriver;

@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_Retry extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_Retry.class);

    @Owner("PAVI")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(false);
    }

    @Owner("PAVI")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }








    }