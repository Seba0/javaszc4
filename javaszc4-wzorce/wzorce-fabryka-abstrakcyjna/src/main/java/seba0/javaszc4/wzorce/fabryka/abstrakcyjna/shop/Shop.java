package seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop;

import seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.SmartDeviceFactory;
import seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.SmartPhone;
import seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.SmartWatch;

public class Shop {
    private final SmartDeviceFactory factory;
    private final SmartWatch watch;
    private final SmartPhone phone;

    public Shop(SmartDeviceFactory factory) {
        this.factory = factory;
        this.watch = factory.createSmartWatch();
        this.phone = factory.createSmartPhone();
    }

    public SmartDeviceFactory getFactory() {
        return factory;
    }

    public SmartWatch getWatch() {
        return watch;
    }

    public SmartPhone getPhone() {
        return phone;
    }
}
