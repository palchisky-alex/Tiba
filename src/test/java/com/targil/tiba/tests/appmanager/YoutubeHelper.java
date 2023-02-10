package com.targil.tiba.tests.appmanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YoutubeHelper extends HelperBase {
    protected static final Logger log = LogManager.getLogger();
    @FindBy(css = "[title='Search for Video'] > :first-child")
    WebElement sort_by_video;
    @FindBy(css = "[title='Sort by view count'] > :first-child")
    WebElement sort_by_count;
    @FindBy(css = "[title='Sort by relevance'] > :first-child")
    WebElement sort_by_relevance;
    @FindBy(css = "input#search")
    WebElement input_search_video;
    @FindBy(css = "#filter-menu  button")
    WebElement btn_filter;
    @FindBy(css = "#filter-menu [aria-hidden='false']")
    WebElement filter_container;
    @FindBy(xpath = "//*[@id='description-inner']//*[text()='ARTIST']/..//*[@href]")
    WebElement artist_descr;
    @FindBy(css = "#description #expand")
    WebElement btn_show_more;

    public YoutubeHelper(WebDriver driver) {
        super(driver);
    }


    public void goToURL(String url) {
        log.info("Entering method: " + getMethodName());
        route(url);
        log.info("Exit method");
    }

    public void searchForVideo(String songName) {
        log.info("Entering method: " + getMethodName());
        type(input_search_video, songName);
        submit(input_search_video);
        log.info("Exit method");
    }

    public void sortListResultsBy(String filter) {
        log.info("Entering method: " + getMethodName());
        openFilterContainer();
        sortBy(filter);
        log.info("Exit method");
    }

    public void openFilterContainer() {
        log.info("Entering method: " + getMethodName());
        click(btn_filter);
        log.info("Exit method");
    }
    public void sortBy(String type) {
        log.info("Entering method: " + getMethodName() + "-" +type);
        switch (type) {
            case "Video":
                click(sort_by_video);
                break;
            case "Count":
                click(sort_by_count);
                break;
            case "Relevance":
                click(sort_by_relevance);
                break;
        }
        wait.until(ExpectedConditions.invisibilityOf(filter_container));
        log.info("Exit method");
    }
    public String getChannelNameById(String id) {
        log.info("Entering method: " + getMethodName() + "-" +id);
        String channel = "#dismissible:has(a[href*='"+id+"']) #channel-info #text";
        WebElement channelElement = driver.findElement(By.cssSelector(channel));
        String text = getText(channelElement);
        log.info("Channel name = " + text);
        log.info("Exit method");
        return text;
    }

    public boolean playVideoById(String id) {
        log.info("Entering method: " + getMethodName());
        String btn = "(//*[@id='video-title'][contains(@href, '"+id+"')])[1]";
        WebElement btn_play_video = driver.findElement(By.xpath(btn));
        click(btn_play_video);
        log.info("Exit method");
        return driver.getCurrentUrl().contains("id");
    }

    public String getVideoDescriptions() {
        log.info("Entering method: " + getMethodName());
        click(btn_show_more);
        String artist_name = getText(artist_descr);
        log.info("Artist Name: " + artist_name);
        log.info("Exit method");
        return artist_name;
    }
}
