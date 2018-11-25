package seba0.javaszc4.wzorce.wizytator.crerit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Optional;

public class BankCreditVisitator {

    private final BigDecimal months;
    private final BigDecimal installmentAmount;


    public BankCreditVisitator(BigDecimal amount, int months) {
        this.months = BigDecimal.valueOf(months);
        this.installmentAmount = amount.divide(this.months, RoundingMode.UP);
    }

    Optional<BigDecimal> averageIncomes(Employee employee, int months) {
        Calendar c = Calendar.getInstance();
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < months; i++) {
            c.add(Calendar.MONTH, -1);
            Optional<BigDecimal> income = employee.getIncome(c.getTime());
            if (!income.isPresent()) {
                return Optional.empty();
            }
            sum = sum.add(income.get());
        }
        return Optional.of(sum.divide(new BigDecimal(months), RoundingMode.DOWN));
    }

    boolean visit(EmployeeB2B b2b) {
        return averageIncomes(b2b, 10)
                .map(amount -> amount.divide(new BigDecimal(3), RoundingMode.DOWN))
                .map(amount -> amount.compareTo(installmentAmount) > 0)
                .orElse(false);
    }

    boolean visit(EmployeeUOP uop) {
        return averageIncomes(uop, 3)
                .map(amount -> amount.compareTo(installmentAmount) > 0)
                .orElse(false);
    }
}
