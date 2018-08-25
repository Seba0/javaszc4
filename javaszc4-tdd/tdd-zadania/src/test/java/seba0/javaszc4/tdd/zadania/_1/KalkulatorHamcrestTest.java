package seba0.javaszc4.tdd.zadania._1;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class KalkulatorHamcrestTest {

    private final Kalkulator kalkulator = new Kalkulator();

    @Test
    public void dodawanieGiven5And10Expected15() {
        //given
        double a = 5;
        double b = 10;
        //when
        double result = kalkulator.dodawanie(a, b);
        //then
        assertThat(
                "result",
                result,
                CoreMatchers.equalTo(a + b));
    }

    @Test
    public void dodawanieGiven4And0Expected4() {
        //given
        double a = 4;
        double b = 0;
        //when
        double result = kalkulator.dodawanie(a, b);
        //then
        assertThat(
                "result",
                result,
                CoreMatchers.equalTo(a + b));
    }

    @Test
    public void odejmowanieGiven5And10ExpectedNeg5() {
        //given
        double a = 5;
        double b = 10;
        //when
        double result = kalkulator.odejmowanie(a, b);
        //then
        assertThat(
                "result",
                result,
                CoreMatchers.equalTo(a - b));
    }

    @Test
    public void odejmowanieGiven4And0Expected4() {
        //given
        double a = 4;
        double b = 0;
        //when
        double result = kalkulator.odejmowanie(a, b);
        //then
        assertThat(
                "result",
                result,
                CoreMatchers.equalTo(a - b));
    }

    @Test
    public void mnozenieGiven5And10Expected50() {
        //given
        double a = 5;
        double b = 10;
        //when
        double result = kalkulator.mnozenie(a, b);
        //then
        assertThat(
                "result",
                result,
                CoreMatchers.equalTo(a * b));
    }

    @Test
    public void mnozenieGiven4And0Expected0() {
        //given
        double a = 4;
        double b = 0;
        //when
        double result = kalkulator.mnozenie(a, b);
        //then
        assertThat(
                "result",
                result,
                CoreMatchers.equalTo(a * b));
    }

    @Test
    public void dzieleneGiven5And10Expected0_5() {
        //given
        double a = 5;
        double b = 10;
        //when
        double result = kalkulator.dzielene(a, b);
        //then
        assertThat(
                "result",
                result,
                CoreMatchers.is(CoreMatchers.equalTo(a / b)));
    }

    @Test(expected = KalkulatorException.class)
    public void dzieleneGiven4And0Expected0() {
        //given
        double a = 4;
        double b = 0;
        //when
        kalkulator.dzielene(a, b);
    }
}