package seba0.javaszc4.wzorce.wizytator.crerit;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EmployeeB2B implements Employee {

    private final Map<Date, BigDecimal> incomes = new HashMap<>();

    @Override
    public Optional<BigDecimal> getIncome(Date date) {
        return Optional.ofNullable(incomes.get(date));
    }

    @Override
    public boolean allowed(BankCreditVisitator visitator) {
        return visitator.visit(this);
    }
}
