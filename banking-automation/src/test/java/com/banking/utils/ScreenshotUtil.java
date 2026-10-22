
package com.banking.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {

    public static void captureScreenshot(
            WebDriver driver, String testName) throws Exception {

        File screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        Path folder = Path.of("target", "screenshots");
        Files.createDirectories(folder);

        Path destination = folder.resolve(
                testName + "_" + System.currentTimeMillis() + ".png");

        Files.copy(screenshot.toPath(), destination);

        System.out.println("Screenshot saved: " + destination);
    }
}
