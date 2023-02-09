package com.targil.tiba.tests.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.time.Duration;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApplicationManager {
    public WebDriver driver;
    YoutubeHelper youtubeHelper;

    public void init() {
        driver = WebDriverManager.chromedriver().create();
        Optional<Path> browserPath = WebDriverManager.chromedriver().getBrowserPath();
        assertThat(browserPath).as("browser is installed in the system").isNotEmpty();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

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
