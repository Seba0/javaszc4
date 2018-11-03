package seba0.javaszc4.wzorce.polecenie.kalkulator;

import seba0.javaszc4.wzorce.polecenie.kalkulator.Command.Command;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class Operation {

    private final Operation prev;
    private Operation next;
    private final BigDecimal value;
    private final Command command;

    Operation(Command command, BigDecimal value) {
        this.prev = null;
        this.command = Objects.requireNonNull(command);
        this.value = Objects.requireNonNull(value);
    }

    Operation(Operation prev, Command command, BigDecimal value) {
        this.prev = Objects.requireNonNull(prev);
        this.prev.setNext(this);
        this.command = Objects.requireNonNull(command);
        this.value = Objects.requireNonNull(value);
    }

    private void setNext(Operation next) {
        this.next = Objects.requireNonNull(next);
    }

    public Optional<Operation> getPrev() {
        return Optional.ofNullable(prev);
    }

    public Optional<Operation> getNext() {
        return Optional.ofNullable(next);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Command getCommand() {
        return command;
    }
}
