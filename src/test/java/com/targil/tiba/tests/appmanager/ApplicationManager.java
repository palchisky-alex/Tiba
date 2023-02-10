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
        String current_os = config.OS();
        if(current_os.equals("MAC")) {
            driver = WebDriverManager.safaridriver().create();
        } else if (current_os.equals("PC")) {
            driver = WebDriverManager.chromedriver().create();
        }
        Optional<Path> browserPath = WebDriverManager.chromedriver().getBrowserPath();
        assumeThat(browserPath).as("browser is installed in the system").isPresent();

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
