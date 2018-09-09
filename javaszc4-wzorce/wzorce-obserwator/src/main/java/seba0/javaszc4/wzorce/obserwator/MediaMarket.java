package seba0.javaszc4.wzorce.obserwator;

import java.util.HashSet;
import java.util.Set;

public class MediaMarket implements Shop {
    private final Set<Subscriber> subscribers = new HashSet<>();

    public boolean addSubscriber(Subscriber subscriber) {
        return subscribers.add(subscriber);
    }

    public boolean removeSubscriber(Subscriber subscriber) {
        return subscribers.remove(subscriber);
    }

    public void sendNewsletter(final Newsletter newsletter) {
        subscribers.parallelStream()
                .forEach(subscriber -> subscriber.notifyAboutNewsletter(newsletter));
    }
}
