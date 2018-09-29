package seba0.javaszc4.wzorce.budowniczy.pc;

import seba0.javaszc4.wzorce.budowniczy.pc.type.*;

public class DesktopBuilder extends ComputerBuilder {

    @Override
    public Computer build() {
        return new Computer(
                ComputerType.DESKTOP,
                Monitor.EXTERNAL,
                ram,
                drive,
                Keyboard.EXTERNAL,
                processor,
                graphicCard,
                networkCard,
                PowerSupplyUnit.INTEGRATED,
                Cover.DESKTOP);
    }
}
