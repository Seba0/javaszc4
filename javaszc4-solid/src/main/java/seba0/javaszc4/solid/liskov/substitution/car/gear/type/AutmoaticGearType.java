package seba0.javaszc4.solid.liskov.substitution.car.gear.type;

public enum AutmoaticGearType implements GearType {
    PARK('P', "Park"),
    REVERSE('R', "Reverse"),
    NEUTRAL('N', "Neutral"),
    DRIVE('D', "Drive");

    private final char code;
    private final String name;

    AutmoaticGearType(char code, String name) {
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
