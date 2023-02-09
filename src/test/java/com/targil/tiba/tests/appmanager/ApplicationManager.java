package com.targil.tiba.tests.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApplicationManager {
    public WebDriver driver;
    YoutubeHelper youtubeHelper;

    public void init() {
        driver = WebDriverManager.chromedriver().create();
        Optional<Path> browserPath = WebDriverManager.chromedriver().getBrowserPath();
        assertThat(browserPath).as("browser is installed in the system").isNotEmpty();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        youtubeHelper = new YoutubeHelper(driver);
    }

    public YoutubeHelper page() {
        return youtubeHelper;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

}
