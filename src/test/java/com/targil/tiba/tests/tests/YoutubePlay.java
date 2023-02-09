package com.targil.tiba.tests.tests;

import org.testng.annotations.Test;

public class YoutubePlay extends TestBase {

    @Test(groups = "youtube")
    public void testMy() throws InterruptedException {
        app.getYoutubeHelper().open();
        app.getYoutubeHelper().searching();
        app.getYoutubeHelper().sortVideoList("Video");
        app.getYoutubeHelper().sortVideoList("Count");
        Thread.sleep(5000);
    }

}
