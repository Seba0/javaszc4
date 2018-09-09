package seba0.javaszc4.wzorce.obserwator;

public class Main {
    public static void main(String[] args) {
        Shop market = new MediaMarket();

        market.addSubscriber(new MediaMarketClient("Jacek"));
        market.addSubscriber(new MediaMarketClient("Marek"));
        market.addSubscriber(new MediaMarketClient("Piotrek"));

        market.sendNewsletter(new Newsletter("Znowu likwidacja sklepu taniej o -70%"));
    }
}
