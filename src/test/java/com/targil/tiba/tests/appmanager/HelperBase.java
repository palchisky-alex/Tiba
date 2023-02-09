package com.targil.tiba.tests.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
