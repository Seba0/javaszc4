package seba0.javaszc4.tdd.wydarzenia;


import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class WydarzenieTest {

    private Wydarzenie wydarzenie;

    @Before
    public void prepare() {
        wydarzenie = new Wydarzenie("Wydarzenie", 3);
    }

    @Test
    public void create() {
        //given
        String nazwa = "Wielkie wydarzenie";
        int maksymalnaIloscUczestnikow = 5;

        //when
        Wydarzenie wielkieWydarzenie = new Wydarzenie(nazwa, maksymalnaIloscUczestnikow);

        //then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(wielkieWydarzenie)
                .isNotNull();
        assertions.assertThat(wielkieWydarzenie.getNazwa())
                .isNotNull()
                .isEqualTo(nazwa);
        assertions.assertThat(wielkieWydarzenie.getMaksymalnaIloscUczestnikow())
                .isNotNull()
                .isEqualTo(maksymalnaIloscUczestnikow);
        assertions.assertThat(wielkieWydarzenie.getUczestnicy())
                .isNotNull()
                .isEmpty();
        assertions.assertAll();
    }

    @Test
    public void addUczestnikTrueIfOneAdded() {
        //given
        Uczestnik uczestnik = new Uczestnik("Jan", "Kowalski", "jan.kowalski@example.com");
        Wydarzenie wydarzenie = new Wydarzenie("Wielkie wydarzenie", 5);

        //when
        boolean added = wydarzenie.addUczestnik(uczestnik);

        //then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(added)
                .isNotNull()
                .isTrue();
        assertions.assertThat(wydarzenie.getUczestnicy())
                .isNotNull()
                .containsExactly(uczestnik);
        assertions.assertThat(wydarzenie.getUczestnicy().size())
                .isNotNull()
                .isEqualTo(1);
        assertions.assertAll();
    }

    @Test()
    public void getUczestnicyUnsupportedOperationExceptionWhenAddUczestnik() {
        //given
        Uczestnik uczestnik = new Uczestnik("Jan", "Kowalski", "jan.kowalski@example.com");
        Set<Uczestnik> uczestnicy = wydarzenie.getUczestnicy();

        //when - then
        Assertions.assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> uczestnicy.add(uczestnik));
    }

    @Test()
    public void getUczestnicyUnsupportedOperationExceptionWhenRemoveUczestnik() {
        //given
        Uczestnik uczestnik = new Uczestnik("Jan", "Kowalski", "jan.kowalski@example.com");
        Set<Uczestnik> uczestnicy = wydarzenie.getUczestnicy();

        //when - then
        Assertions.assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> uczestnicy.remove(uczestnik));
    }
}
