package com.targil.tiba.tests.appmanager;

import com.targil.tiba.Setup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Optional;

import static org.assertj.core.api.Assumptions.assumeThat;

public class ApplicationManager {
    public WebDriver driver;
    YoutubeHelper youtubeHelper;
    Setup config;

    public ApplicationManager(Setup config) {
        this.config = config;
    }

    public void init() {
        String browser_config = config.browser();
        switch(browser_config) {
            case "Chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "Firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "Edge":
                driver = WebDriverManager.edgedriver().create();
                break;
            case "Opera":
                driver = WebDriverManager.operadriver().create();
                break;
        }

        Optional<Path> browserPath = WebDriverManager.chromedriver().getBrowserPath();
        assumeThat(browserPath).as("browser installed").isPresent();

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
