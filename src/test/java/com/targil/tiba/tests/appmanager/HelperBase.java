package com.targil.tiba.tests.appmanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {

    WebDriver driver;
    WebDriverWait wait;
    protected static final Logger log = LogManager.getLogger();
    public HelperBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public void route(String url) {
        String currentURL = driver.getCurrentUrl();
        if(!currentURL.equals(url)) {
            driver.get(url);
            wait.until(ExpectedConditions.urlToBe(url));
        }
    }

    public void click(WebElement el) {
        elementToBeClickable(el);
        log.info("click on " + el);
        el.click();
    }
    public void submit(WebElement el) {
        log.info("submit " + el);
        el.sendKeys(Keys.ENTER);;
    }
    public void type(WebElement el, String text) {
        elementToBeClickable(el);
        log.info("send text: " + text + " to " + el);
        el.click();
        el.sendKeys(text);
    }
    public String getText(WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
        log.info("get text from " + el);
        return el.getText();
    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public void elementToBeClickable(WebElement el) {
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }
}
