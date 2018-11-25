package seba0.javaszc4.wzorce.wizytator.crerit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankCreditVisitatorTest {

    private BankCreditVisitator visitator;

    @BeforeClass
    public void init() {
        visitator = new BankCreditVisitator(new BigDecimal(2000), 6);
    }

    @DataProvider
    public static Object[][] dataAverageIncomes() {
        Employee employee = mock(Employee.class);
        Optional<BigDecimal> ten = Optional.of(BigDecimal.TEN);
        when(employee.getIncome(any(Date.class))).thenAnswer(arg0 -> {
            System.out.println(Arrays.toString(arg0.getArguments()));
            return ten;
        });
        return new Object[][]{
                {employee, 3, ten},
                {employee, 6, ten},
                {employee, 12, ten}
        };
    }

    @Test(dataProvider = "dataAverageIncomes")
    public void testAverageIncomes(Employee employee, int months, Optional<BigDecimal> expected) {
        // when
        Optional<BigDecimal> result = visitator.averageIncomes(employee, months);

        // then
        assertThat(result)
                .isEqualTo(expected);
    }

//    @Test
//    public void testVisitB2B(EmployeeB2B employee, boolean expected) {
//        // when
//        boolean result = visitator.visit(employee);
//
//        // then
//        assertThat(result)
//                .isEqualTo(expected);
//    }
//
//    @Test
//    public void testVisitUOP(EmployeeUOP employee, boolean expected) {
//        // when
//        boolean result = visitator.visit(employee);
//
//        // then
//        assertThat(result)
//                .isEqualTo(expected);
//    }
}