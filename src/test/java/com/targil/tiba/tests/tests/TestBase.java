package com.targil.tiba.tests.tests;

import com.targil.tiba.tests.appmanager.ApplicationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();


    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.init();
    }


    @AfterSuite(alwaysRun = true)
    public void stop() {
        app.stop();
    }

}
