package seba0.javaszc4.wzorce.metoda.szablonowa.pc;

import seba0.javaszc4.wzorce.metoda.szablonowa.pc.type.Ram;
import seba0.javaszc4.wzorce.metoda.szablonowa.pc.type.SoftWare;
import seba0.javaszc4.wzorce.metoda.szablonowa.pc.type.Vendor;

public class BasicComputerSetup extends ComputerSetup {

    private final Vendor vendor;

    public BasicComputerSetup(Computer computer, Vendor vendor) {
        super(computer);
        this.vendor = vendor;
    }

    @Override
    public void addMotherBoard(Computer computer) {
        computer.setMotherBoard(new MotherBoard("Basic " + vendor.name() + " PC", vendor));
    }

    @Override
    public void addProcessor(MotherBoard board) {
        board.setProcessor(vendor);
    }

    @Override
    public void addRam(MotherBoard board) {
        board.setRam(Ram._6);
    }

    @Override
    public void addGraphicCard(MotherBoard board) {
        board.setGraphicCard(vendor);
    }

    @Override
    public void addSoftware(Computer computer) {
        computer.setSoftWare(SoftWare.WINDOWS);
    }
}
