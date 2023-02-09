package com.targil.tiba.tests.tests;

import com.targil.tiba.tests.appmanager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
