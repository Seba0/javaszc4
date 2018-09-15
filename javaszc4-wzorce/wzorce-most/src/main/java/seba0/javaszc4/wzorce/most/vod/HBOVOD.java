package seba0.javaszc4.wzorce.most.vod;

import java.util.Objects;

public class HBOVOD implements VOD {

    private final PlayerAPI api;

    public HBOVOD(PlayerAPI api) {
        this.api = Objects.requireNonNull(api);
    }

    @Override
    public void startPlay() {
        api.play();
    }

    @Override
    public void stopPlay() {
        api.play();
        api.pause();
    }
}
