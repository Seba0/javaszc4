package seba0.javaszc4.wzorce.polecenie.kalkulator.Command;

import java.math.BigDecimal;

public class DivideCommand implements Command {

    @Override
    public BigDecimal execute(BigDecimal value1, BigDecimal value2) {
        return value1.divide(value2);
    }
}
