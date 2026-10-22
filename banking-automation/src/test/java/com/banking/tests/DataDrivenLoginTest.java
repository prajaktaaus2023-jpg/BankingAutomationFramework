
package com.banking.tests;

import com.banking.base.BaseTest;
import com.banking.pages.LoginPage;
import com.banking.utils.CSVReader;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenLoginTest extends BaseTest {


@DataProvider(name = "loginData")
public Object[][] getLoginData() throws Exception {

    return CSVReader.readLoginData();
}


    @Test(dataProvider = "loginData")
    public void loginTest(String username,
                          String password,
                          boolean expectedSuccess) {

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage login = new LoginPage(driver);

        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();

        String message = login.getMessage();

        if (expectedSuccess) {
            Assert.assertTrue(
                message.contains("You logged into a secure area!")
            );
        } else {
            Assert.assertTrue(
                message.contains("invalid!")
            );
        }

        System.out.println("Test completed for: " + username);
    }
}
