package seba0.javaszc4.wzorce.polecenie.kalkulator.Command;

import java.math.BigDecimal;

@FunctionalInterface
public interface Command {

    BigDecimal execute(BigDecimal value1, BigDecimal value2);

}
