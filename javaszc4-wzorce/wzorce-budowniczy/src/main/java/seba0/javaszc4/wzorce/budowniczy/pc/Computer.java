package seba0.javaszc4.wzorce.budowniczy.pc;

import seba0.javaszc4.wzorce.budowniczy.pc.type.*;

public class Computer {

    private ComputerType type;
    private Monitor monitor;
    private Ram ram;
    private Drive drive;
    private Keyboard keyboard;
    private Processor processor;
    private GraphicCard graphicCard;
    private NetworkCard networkCard;
    private PowerSupplyUnit powerSupplyUnit;
    private Cover cover;

    Computer(ComputerType type, Monitor monitor, Ram ram, Drive drive, Keyboard keyboard, Processor processor, GraphicCard graphicCard, NetworkCard networkCard, PowerSupplyUnit powerSupplyUnit, Cover cover) {
        this.type = type;
        this.monitor = monitor;
        this.ram = ram;
        this.drive = drive;
        this.keyboard = keyboard;
        this.processor = processor;
        this.graphicCard = graphicCard;
        this.networkCard = networkCard;
        this.powerSupplyUnit = powerSupplyUnit;
        this.cover = cover;
    }

    public ComputerType getType() {
        return type;
    }

    public void setType(ComputerType type) {
        this.type = type;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    public NetworkCard getNetworkCard() {
        return networkCard;
    }

    public void setNetworkCard(NetworkCard networkCard) {
        this.networkCard = networkCard;
    }

    public PowerSupplyUnit getPowerSupplyUnit() {
        return powerSupplyUnit;
    }

    public void setPowerSupplyUnit(PowerSupplyUnit powerSupplyUnit) {
        this.powerSupplyUnit = powerSupplyUnit;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }
}
