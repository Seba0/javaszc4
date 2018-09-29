package seba0.javaszc4.wzorce.metoda.szablonowa.pc;

import seba0.javaszc4.wzorce.metoda.szablonowa.pc.type.SoftWare;

public class Computer implements Named {
    private final String name;
    private MotherBoard motherBoard;
    private SoftWare softWare;

    public Computer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public Computer setMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
        return this;
    }

    public SoftWare getSoftWare() {
        return softWare;
    }

    public Computer setSoftWare(SoftWare softWare) {
        this.softWare = softWare;
        return this;
    }
}
