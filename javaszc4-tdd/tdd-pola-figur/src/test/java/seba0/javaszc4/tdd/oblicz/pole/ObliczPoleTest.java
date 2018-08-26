package seba0.javaszc4.tdd.oblicz.pole;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ObliczPoleTest {

    @Test
    public void prostokat20KiedyWysokosc4ISzerokosc5() {
        //given
        double wysokosc = 4;
        double szerokosc = 5;

        //when
        double wynik = ObliczPole.prostokata(wysokosc, szerokosc);

        //then
        assertThat(wynik)
                .isNotNull()
                .isEqualTo(20);
    }

    @Test
    public void prostokatWyjatekKiedyWysokoscMinus4() {
        //given
        double wysokosc = -4;
        double szerokosc = 5;

        //when - then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ObliczPole.prostokata(wysokosc, szerokosc));
    }

    @Test
    public void kwadratu25KiedyWysokosc5() {
        //given
        double wysokosc = 5;

        //when
        double wynik = ObliczPole.kwadratu(wysokosc);

        //then
        assertThat(wynik)
                .isNotNull()
                .isEqualTo(25);
    }

    @Test
    public void kwadratuWyjatekKiedyWysokoscMinus4() {
        //given
        double wysokosc = -4;

        //when - then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ObliczPole.kwadratu(wysokosc));
    }

    @Test
    public void trapezu25KiedyWysokosc5() {
        //given
        double wysokosc = 5;
        double podstawaA = 4;
        double podstawaB = 3;

        //when
        double wynik = ObliczPole.trapezu(wysokosc, podstawaA, podstawaB);

        //then
        assertThat(wynik)
                .isNotNull()
                .isEqualTo(17.5);
    }

    @Test
    public void trapezuWyjatekKiedyWysokoscMinus4() {
        //given
        double wysokosc = -4;
        double podstawaA = 4;
        double podstawaB = 3;

        //when - then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ObliczPole.trapezu(wysokosc, podstawaA, podstawaB));
    }

    @Test
    public void kola25KiedyPromien5() {
        //given
        double promien = 5;

        //when
        double wynik = ObliczPole.kola(promien);

        //then
        assertThat(wynik)
                .isNotNull()
                .isEqualTo(78.5398, Offset.offset(4.0));
    }

    @Test
    public void kolauWyjatekKiedyPromienMinus4() {
        //given
        double promien = -4;

        //when - then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ObliczPole.kola(promien));
    }
}
