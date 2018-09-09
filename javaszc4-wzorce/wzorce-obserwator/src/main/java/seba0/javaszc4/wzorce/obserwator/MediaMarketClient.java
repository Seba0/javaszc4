package seba0.javaszc4.wzorce.obserwator;

public class MediaMarketClient implements Subscriber {

    private final String name;

    public MediaMarketClient(String name) {
        this.name = name;
    }

    @Override
    public void notifyAboutNewsletter(Newsletter newsletter) {
        System.out.println(name + " get new news: " + newsletter);
    }
}
