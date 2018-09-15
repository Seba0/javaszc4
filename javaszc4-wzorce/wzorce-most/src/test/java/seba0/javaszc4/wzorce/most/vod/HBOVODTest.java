package seba0.javaszc4.wzorce.most.vod;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HBOVODTest {

    private PlayerAPI api;
    private VOD vod;

    @BeforeMethod
    public void setUp() {
        //given
        api = Mockito.mock(PlayerAPI.class);
        vod = new HBOVOD(api);
    }

    @Test
    public void testStartPlay() {
        // when
        vod.startPlay();

        //then
        Mockito.verify(api, Mockito.times(1)).play();
        Mockito.verify(api, Mockito.never()).pause();
        Mockito.verify(api, Mockito.never()).next();
        Mockito.verify(api, Mockito.never()).prev();
    }

    @Test
    public void testStopPlay() {
        //when
        vod.stopPlay();

        //then
        Mockito.verify(api, Mockito.times(1)).play();
        Mockito.verify(api, Mockito.times(1)).pause();
        Mockito.verify(api, Mockito.never()).next();
        Mockito.verify(api, Mockito.never()).prev();
    }
}