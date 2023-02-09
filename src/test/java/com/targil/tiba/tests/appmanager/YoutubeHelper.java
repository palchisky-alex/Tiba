package com.targil.tiba.tests.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YoutubeHelper extends HelperBase {
    WebDriverWait wait;
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

    public void select_filter() {
        driver.findElement(By.cssSelector("#filter-menu  button")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#filter-menu [aria-hidden='true']")));
    }
}
