package seba0.javaszc4.wzorce.polecenie.kalkulator;

import seba0.javaszc4.wzorce.polecenie.kalkulator.Command.Command;
import seba0.javaszc4.wzorce.polecenie.kalkulator.Command.SetCommand;

import java.math.BigDecimal;

public class Calculator {

    private BigDecimal value;
    private Operation operation;

    public Calculator() {
        this(BigDecimal.ZERO);
    }

    public Calculator(BigDecimal value) {
        this.value = value;
        operation = new Operation(new SetCommand(), value);
    }

    public Calculator addOperation(Command command, BigDecimal value) {
        this.value = command.execute(this.value, value);
        operation = new Operation(command, value);
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Operation getOperation() {
        return operation;
    }
}
