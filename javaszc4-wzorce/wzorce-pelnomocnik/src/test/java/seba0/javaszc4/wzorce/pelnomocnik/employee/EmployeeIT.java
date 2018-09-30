package seba0.javaszc4.wzorce.pelnomocnik.employee;

import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.testng.annotations.Test;

public class EmployeeIT {
    @Test
    public void testDeveloper() {
        Employee employee = Mockito.mock(Developer.class);
        Mockito.doCallRealMethod().when(employee).hasPermission();
        Mockito.doCallRealMethod().when(employee).generateTimeReport();

        Assertions.assertThat(employee).isNotNull();

        Mockito.verifyZeroInteractions(employee);

        Assertions.assertThat(employee.hasPermission()).isFalse();
        Mockito.verify(employee, Mockito.times(1)).hasPermission();
        Mockito.verify(employee, Mockito.never()).generateTimeReport();


        employee.generateTimeReport();

        Mockito.verify(employee, Mockito.times(1)).generateTimeReport();

        ProxyEmployee proxyEmployee = new ProxyEmployee(employee);

        Assertions.assertThat(proxyEmployee).isNotNull();

        Assertions.assertThat(proxyEmployee.hasPermission()).isFalse();
        Mockito.verify(employee, Mockito.times(2)).hasPermission();
        Mockito.verify(employee, Mockito.times(1)).generateTimeReport();

        Assertions.assertThatExceptionOfType(SecurityException.class)
                .isThrownBy(() -> proxyEmployee.generateTimeReport());
        Mockito.verify(employee, Mockito.times(3)).hasPermission();
        Mockito.verify(employee, Mockito.times(1)).generateTimeReport();
    }
}