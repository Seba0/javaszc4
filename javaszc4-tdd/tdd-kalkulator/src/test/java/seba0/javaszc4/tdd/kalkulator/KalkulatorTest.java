package seba0.javaszc4.tdd.kalkulator;

import org.junit.Assert;
import org.junit.Test;

public class KalkulatorTest {

    private Kalkulator kalkulator = new Kalkulator();

    @Test
    public void dodaj() {
        //given
        double a = 10;
        double b = 20;

        //when
        double result = kalkulator.dodawanie(a, b);

        //then
        Assert.assertEquals(a + b, result, 0);
    }

    @Test
    public void dodaj2() {
        //given
        double a = -3;
        double b = 0;

        //when
        double result = kalkulator.dodawanie(a, b);

        //then
        Assert.assertEquals(a + b, result, 0);
    }

    @Test
    public void odejmowanie() {
        //given
        double a = 10;
        double b = 20;

        //when
        double result = kalkulator.odejmowanie(a, b);

        //then
        Assert.assertEquals(a - b, result, 0);
    }

    @Test
    public void odejmowanie2() {
        //given
        double a = -3;
        double b = 0;

        //when
        double result = kalkulator.odejmowanie(a, b);

        //then
        Assert.assertEquals(a - b, result, 0);
    }

    @Test
    public void dzielenie() throws KalkulatorException {
        //given
        double a = 10;
        double b = 20;

        //when
        double result = kalkulator.dzielenie(a, b);

        //then
        Assert.assertEquals(a / b, result, 0);
    }

    @Test(expected = KalkulatorException.class)
    public void dzielenie2() throws KalkulatorException {
        //given
        double a = -3;
        double b = 0;

        //when
        double result = kalkulator.dzielenie(a, b);

        //then
        Assert.assertEquals(a / b, result, 0);
    }
}