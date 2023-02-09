package com.targil.tiba.tests.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class YoutubeHelper extends HelperBase {

    @FindBy(css = "[title='Search for Video'] > :first-child")
    WebElement sort_by_video;
    @FindBy(css = "[title='Sort by view count'] > :first-child")
    WebElement sort_by_count;
    @FindBy(css = "#filter-menu  button")
    WebElement btn_filter;
    @FindBy(css = "#filter-menu [aria-hidden='false']")
    WebElement filter_container;


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public YoutubeHelper(WebDriver driver) {
        super(driver);
    }


    public void open() {
        driver.get("https://www.youtube.com");
    }

    public void searching() {
        WebElement el = driver.findElement(By.cssSelector("input#search"));
        el.click();
        el.sendKeys("I Will Survive - Alien song");
        el.sendKeys(Keys.ENTER);
    }

    public void sortVideoList(String filter_name) throws InterruptedException {
        openFilterContainer();
        sortBy(filter_name);

    }

    public void openFilterContainer() {
        click(btn_filter);
    }

    public void sortBy(String type) {

        switch (type) {
            case "Video":
                click(sort_by_video);
                break;
            case "Count":
                click(sort_by_count);
                break;
            default:
                click(sort_by_count);
        }
        wait.until(ExpectedConditions.invisibilityOf(filter_container));
    }

    public void click(WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
        el.click();
    }
}
