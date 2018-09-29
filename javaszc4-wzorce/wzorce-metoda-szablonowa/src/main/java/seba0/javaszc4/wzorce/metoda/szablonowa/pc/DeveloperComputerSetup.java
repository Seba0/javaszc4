package seba0.javaszc4.wzorce.metoda.szablonowa.pc;

import seba0.javaszc4.wzorce.metoda.szablonowa.pc.type.Ram;
import seba0.javaszc4.wzorce.metoda.szablonowa.pc.type.SoftWare;
import seba0.javaszc4.wzorce.metoda.szablonowa.pc.type.Vendor;

public class DeveloperComputerSetup extends ComputerSetup {

    private static final Vendor VENDOR = Vendor.INTEL;

    public DeveloperComputerSetup(Computer computer) {
        super(computer);
    }

    @Override
    public void addMotherBoard(Computer computer) {
        computer.setMotherBoard(new MotherBoard("Basic " + VENDOR.name() + " PC", VENDOR));
    }

    @Override
    public void addProcessor(MotherBoard board) {
        board.setProcessor(VENDOR);
    }

    @Override
    public void addRam(MotherBoard board) {
        board.setRam(Ram._16);
    }

    @Override
    public void addGraphicCard(MotherBoard board) {
        board.setGraphicCard(VENDOR);
    }

    @Override
    public void addSoftware(Computer computer) {
        computer.setSoftWare(SoftWare.LINUX);
    }
}
