package com.targil.tiba.tests.tests;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class YoutubePlay extends TestBase {

    @Test(groups = "youtube")
    public void testMy() {
        app.page().goToURL("https://www.youtube.com/");
        app.page().searchForVideo("I Will Survive - Alien song");
        app.page().sortListResults("Video");
        app.page().sortListResults("Count");

        String channelName = app.page().getChannelNameById("ybXrrTX3LuI");
        Boolean play = app.page().playVideoById("ybXrrTX3LuI");
        String artistName = app.page().getVideoDescriptions();

        assertThat(play).as("Video is playing").isTrue();
        assertThat(channelName).as("Check channel name").isEqualTo("nikki7993");
        assertThat(artistName).as("Check artist name").isEqualTo("Gloria Gaynor");
    }

}
