package seba0.javaszc4.wzorce.budowniczy.pc;

import seba0.javaszc4.wzorce.budowniczy.pc.type.*;

public class NotebookBuilder extends ComputerBuilder {

    @Override
    public Computer build() {
        return new Computer(
                ComputerType.NOTEBOOK,
                Monitor.INTEGRATED,
                ram,
                drive,
                Keyboard.INTEGRATED,
                processor,
                graphicCard,
                networkCard,
                PowerSupplyUnit.EXTERNAL,
                Cover.LAPTOP);
    }
}
