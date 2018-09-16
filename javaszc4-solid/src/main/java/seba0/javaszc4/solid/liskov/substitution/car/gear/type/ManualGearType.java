package seba0.javaszc4.solid.liskov.substitution.car.gear.type;

public enum ManualGearType implements GearType {
    DRIVE_1('1', "Drive 1"),
    DRIVE_2('2', "Drive 2"),
    DRIVE_3('3', "Drive 3"),
    DRIVE_4('4', "Drive 4"),
    REVERSE('R', "Reverse"),
    NEUTRAL('N', "Neutral");

    private final char code;
    private final String name;

    ManualGearType(char code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public char getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }
}
