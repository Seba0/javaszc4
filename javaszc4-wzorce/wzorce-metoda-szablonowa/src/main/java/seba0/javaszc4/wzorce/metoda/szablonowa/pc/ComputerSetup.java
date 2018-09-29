package seba0.javaszc4.wzorce.metoda.szablonowa.pc;

public abstract class ComputerSetup {

    private final Computer computer;

    public ComputerSetup(Computer computer) {
        this.computer = computer;
    }

    public final void setup() {
        addMotherBoard(computer);
        MotherBoard motherBoard = computer.getMotherBoard();
        addProcessor(motherBoard);
        addRam(motherBoard);
        addGraphicCard(motherBoard);
        addSoftware(computer);
    }

    public abstract void addMotherBoard(Computer computer);

    public abstract void addProcessor(MotherBoard board);

    public abstract void addRam(MotherBoard board);

    public abstract void addGraphicCard(MotherBoard board);

    public abstract void addSoftware(Computer computer);
}
