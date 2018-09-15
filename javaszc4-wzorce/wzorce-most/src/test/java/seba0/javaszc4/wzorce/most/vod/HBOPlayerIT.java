package seba0.javaszc4.wzorce.most.vod;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seba0.javaszc4.wzorce.most.vod.players.ExoPlayer;
import seba0.javaszc4.wzorce.most.vod.players.MediaPlayer;

public class HBOPlayerIT {

    @DataProvider
    public static Object[][] playerDataProvider() {
        return new PlayerAPI[][]{
                {new MediaPlayer()},
                {new ExoPlayer()}
        };
    }

    @Test
    public void testCreatePlayStop(PlayerAPI api) {
        SoftAssertions.assertSoftly(soft -> {

            soft.assertThat(api)
                    .isNotNull();

            VOD vod = new HBOVOD(api);

            soft.assertThat(vod)
                    .isNotNull();

            vod.startPlay();

            vod.stopPlay();
        });
    }
}
