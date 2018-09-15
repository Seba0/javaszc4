package seba0.javaszc4.wzorce.most.vod.players;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import seba0.javaszc4.wzorce.most.vod.PlayerAPI;

import static org.testng.Assert.*;

public class ExoPlayerTest {

    private PlayerAPI api;

    @BeforeMethod
    public void setUp() {
        api = new ExoPlayer();
    }

    @Test
    public void testPlay() {
        //when
        api.play();
    }

    @Test
    public void testPause() {
        //when
        api.pause();
    }

    @Test
    public void testNext() {
        //when
        api.next();
    }

    @Test
    public void testPrev() {
        //when
        api.prev();
    }
}