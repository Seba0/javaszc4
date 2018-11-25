package seba0.javaszc4.wzorce.wizytator.crerit;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public interface Employee {

    Optional<BigDecimal> getIncome(Date date);

    boolean allowed(BankCreditVisitator visitator);
}
