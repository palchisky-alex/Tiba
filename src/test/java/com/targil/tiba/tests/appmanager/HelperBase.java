package com.targil.tiba.tests.appmanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {

    WebDriver driver;
    static WebDriverWait wait;
    protected static final Logger log = LogManager.getLogger();

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitUntil(String condition, WebElement el, int sec, String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        switch (condition) {
            case "elementToBeClickable":
                wait.until(ExpectedConditions.elementToBeClickable(el));
                break;
            case "textToBePresentInElement":
                wait.until(ExpectedConditions.textToBePresentInElement(el, text));
                break;
            case "invisibilityOf":
                wait.until(ExpectedConditions.invisibilityOf(el));
                break;
            case "visibilityOf":
                wait.until(ExpectedConditions.visibilityOf(el));
                break;
        }
        log.info("wait until " + "(" + el + ") " + condition + " | " + text);
    }

    public void waitUntil(String condition, String text) {
        log.info("wait until " + condition + ", " + text);
    }

    public void route(String url) {
        String currentURL = driver.getCurrentUrl();
        if (!currentURL.equals(url)) {
            driver.get(url);
            waitUntil("urlToBe", url);
        }
    }

    public void click(WebElement el) {
        waitUntil("elementToBeClickable", el, 5, "");
        log.info("click on " + el);
        try {
            el.click();
        } catch (NoSuchElementException e) {
            log.info("Element not found!");
        } catch (ElementNotInteractableException e) {
            log.info("Element not interactable!");
        } catch (Exception e) {
            log.info("element is no longer attached to the DOM " + e);
        }

    }

    public void submit(WebElement el) {
        log.info("submit " + el);
        el.sendKeys(Keys.ENTER);
    }

    public void type(WebElement el, String text) {
        waitUntil("elementToBeClickable", el, 5, "");
        log.info("send text: " + text + " to " + el);
        el.sendKeys(text);
    }

    public String getText(WebElement el) {
        waitUntil("visibilityOf", el, 5, "");
        log.info("get text from " + el);
        return el.getText();
    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }


}
