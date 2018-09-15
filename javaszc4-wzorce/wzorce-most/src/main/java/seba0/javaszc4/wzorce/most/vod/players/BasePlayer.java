package seba0.javaszc4.wzorce.most.vod.players;

import seba0.javaszc4.wzorce.most.vod.PlayerAPI;

abstract class BasePlayer implements PlayerAPI {
    @Override
    public void play() {
        System.out.println(getClass().getSimpleName() + ": Play");
    }

    @Override
    public void pause() {
        System.out.println(getClass().getSimpleName() + ": Pause");
    }

    @Override
    public void next() {
        System.out.println(getClass().getSimpleName() + ": Next");
    }

    @Override
    public void prev() {
        System.out.println(getClass().getSimpleName() + ": Prev");
    }
}
