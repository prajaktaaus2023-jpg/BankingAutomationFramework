
package com.banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void verifyPageTitle() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://example.com");

            String actualTitle = driver.getTitle();

            Assert.assertEquals(actualTitle, "Example Domain");

            System.out.println("Test Passed: " + actualTitle);

        } finally {
            driver.quit();
        }
    }
}
