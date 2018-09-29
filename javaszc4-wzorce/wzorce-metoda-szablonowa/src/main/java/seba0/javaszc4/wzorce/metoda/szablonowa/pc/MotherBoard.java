package seba0.javaszc4.wzorce.metoda.szablonowa.pc;

import seba0.javaszc4.wzorce.metoda.szablonowa.pc.type.Ram;
import seba0.javaszc4.wzorce.metoda.szablonowa.pc.type.Vendor;

import javax.annotation.processing.Processor;

public class MotherBoard implements Named {
    private final String name;
    private final Vendor vendor;
    private Vendor processor;
    private Ram ram;
    private Vendor graphicCard;


    public MotherBoard(String name, Vendor vendor) {
        this.name = name;
        this.vendor = vendor;
    }

    @Override
    public String getName() {
        return name;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public Vendor getProcessor() {
        return processor;
    }

    public void setProcessor(Vendor processor) {
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Vendor getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(Vendor graphicCard) {
        this.graphicCard = graphicCard;
    }
}
