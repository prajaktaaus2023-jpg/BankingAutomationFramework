
package com.banking.tests;

import com.banking.base.BaseTest;
import com.banking.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        // Open login page
        driver.get("https://the-internet.herokuapp.com/login");

        // Create LoginPage object
        LoginPage login = new LoginPage(driver);

        // Enter login details
        login.enterUsername("tomsmith");
        login.enterPassword("SuperSecretPassword!");
        login.clickLogin();

        // Validate successful login
        String actualMessage = login.getMessage();

        Assert.assertTrue(
            actualMessage.contains("You logged into a secure area!"),
            "Login success message not displayed"
        );

        System.out.println("Login Test Passed");
    }
}
