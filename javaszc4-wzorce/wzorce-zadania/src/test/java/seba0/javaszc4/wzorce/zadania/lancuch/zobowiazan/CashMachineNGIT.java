package seba0.javaszc4.wzorce.zadania.lancuch.zobowiazan;

import java.util.Map;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author sebastian
 */
public class CashMachineNGIT {

    private CashMachine machine;

    @BeforeTest
    public void init() {
        machine = new CashMachine();
        machine.add(Nominal._200, 2);
        machine.add(Nominal._100, 10);
        machine.add(Nominal._50, 3);
        machine.add(Nominal._20, 10);
    }

    @Test
    public void testPay() {
        //given
        int money = 750;

        //when
        Map<Nominal, Integer> result = machine.pull(money);

        //then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(result)
                    .isNotNull()
                    .isNotEmpty()
                    .containsOnlyKeys(Nominal._200, Nominal._100, Nominal._50)
                    .containsEntry(Nominal._200, 2)
                    .containsEntry(Nominal._100, 3)
                    .containsEntry(Nominal._50, 1);
        });
    }
}
