package seba0.javaszc4.wzorce.obserwator;

public interface Shop {
    boolean addSubscriber(Subscriber subscriber);

    boolean removeSubscriber(Subscriber subscriber);

    void sendNewsletter(Newsletter newsletter);
}
