package seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.apple;

import seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.SmartDeviceFactory;
import seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.SmartPhone;
import seba0.javaszc4.wzorce.fabryka.abstrakcyjna.shop.smart.SmartWatch;

public class AppleFactory implements SmartDeviceFactory {
    @Override
    public SmartWatch createSmartWatch() {
        return new AppleWatch();
    }

    @Override
    public SmartPhone createSmartPhone() {
        return new IPhone();
    }
}
