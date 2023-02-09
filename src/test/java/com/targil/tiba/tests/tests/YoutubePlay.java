package com.targil.tiba.tests.tests;

import org.testng.annotations.Test;

public class YoutubePlay extends TestBase {

    @Test(groups = "youtube")
    public void testMy() throws InterruptedException {
        app.getYoutubeHelper().open();
        app.getYoutubeHelper().searching();
        app.getYoutubeHelper().sortListResults("Video");
        app.getYoutubeHelper().sortListResults("Count");
        app.getYoutubeHelper().getChannelNameById("ybXrrTX3LuI");
        app.getYoutubeHelper().playVideoById("ybXrrTX3LuI");
        app.getYoutubeHelper().getVideoDescriptions();
        Thread.sleep(5000);
    }

}
