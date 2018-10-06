package seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.google;

import seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.SmartDeviceFactory;
import seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.SmartPhone;
import seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.SmartWatch;

public class GoogleFactory implements SmartDeviceFactory {
    @Override
    public SmartWatch createSmartWatch() {
        return new WearOSWatch();
    }

    @Override
    public SmartPhone createSmartPhone() {
        return new GooglePixel();
    }
}
