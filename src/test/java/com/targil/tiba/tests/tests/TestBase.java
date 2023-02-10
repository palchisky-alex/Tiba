package com.targil.tiba.tests.tests;
import com.targil.tiba.Setup;
import com.targil.tiba.tests.appmanager.ApplicationManager;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(ConfigFactory.create(Setup.class));


    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.init();
    }


    @AfterSuite(alwaysRun = true)
    public void stop() {
        app.stop();
    }

}
