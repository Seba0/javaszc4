package seba0.javaszc4.wzorce.budowniczy.pc;

import seba0.javaszc4.wzorce.budowniczy.pc.type.*;

public abstract class ComputerBuilder {

    protected Monitor monitor;
    protected Ram ram;
    protected Drive drive;
    protected Processor processor;
    protected GraphicCard graphicCard;
    protected NetworkCard networkCard;

    public ComputerBuilder setMonitor(Monitor monitor) {
        this.monitor = monitor;
        return this;
    }

    public ComputerBuilder setRam(Ram ram) {
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setDrive(Drive drive) {
        this.drive = drive;
        return this;
    }

    public ComputerBuilder setProcessor(Processor processor) {
        this.processor = processor;
        return this;
    }

    public ComputerBuilder setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
        return this;
    }

    public ComputerBuilder setNetworkCard(NetworkCard networkCard) {
        this.networkCard = networkCard;
        return this;
    }

    public abstract Computer build();
}
