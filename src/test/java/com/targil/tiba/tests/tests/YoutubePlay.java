package com.targil.tiba.tests.tests;

import org.testng.annotations.Test;

public class YoutubePlay extends TestBase {

    @Test(groups = "youtube")
    public void testMy() {
        app.getYoutubeHelper().open();
        app.getYoutubeHelper().searching();
        app.getYoutubeHelper().select_filter();
    }

}
