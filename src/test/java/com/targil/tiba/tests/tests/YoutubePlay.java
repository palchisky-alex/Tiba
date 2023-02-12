package com.targil.tiba.tests.tests;

import com.targil.tiba.tests.appmanager.Excel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YoutubePlay extends TestBase {
    SoftAssertions soft = new SoftAssertions();
    @Test(dataProvider = "getMyDataFromExcel", groups = "youtube")
    public void testTiba(String song, String song_id, String channel, String artist) throws InterruptedException {
        app.page().goToURL("https://www.youtube.com/");
        app.page().searchForVideo(song);
        app.page().sortListResultsBy("Video");
        app.page().sortListResultsBy("Count");
        app.page().sortListResultsBy("Relevance");

        String channelName = app.page().getChannelNameById(song_id);
        soft.assertThat(channelName).as("Channel name").isEqualTo(channel);

        Boolean play = app.page().playVideoById(song_id);
        soft.assertThat(play).as("Video is playing").isTrue();

        String artistName = app.page().getVideoDescriptions();
        soft.assertThat(artistName).as("Artist name is present").isEqualTo(artist);
    }


    @DataProvider
    public Object[][] getMyDataFromExcel() {
        Excel excel = new Excel();
        return excel.getTableArray(System.getProperty("user.dir") + "/src/test/resources/tiba_input.xlsx", "youtube");
    }

}
