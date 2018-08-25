package seba0.javaszc4.tdd.zadania._2;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.BeforeClass;
import org.junit.Test;

public class WydarzenieTest {

    private static Wydarzenie wydarzenie;
    private static String nazwa;
    private static Uczestnik uczestnik;

    @BeforeClass
    public static void init() {
        nazwa = "Event 2018";
        wydarzenie = new Wydarzenie(nazwa);
        uczestnik = new Uczestnik("Jan", "Kowalski", "mail@example.com", "0048123456789");
    }

    @Test
    public void getNazwaEqualsNazwa() {
        //when
        String result = wydarzenie.getNazwa();
        //then
        Assertions
                .assertThat(result)
                .isEqualTo(nazwa);
    }

    @Test
    public void getListaUczestnikowNotNull() {
        // then
        Assertions
                .assertThat(wydarzenie.getListaUczestnikow())
                .isNotNull();
    }

    @Test
    public void addUczestnikSecondTime() {
        //when
        boolean first = wydarzenie.addUczestnik(uczestnik);
        boolean second = wydarzenie.addUczestnik(uczestnik);
        // then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(first).isTrue();
        assertions.assertThat(second).isFalse();
        assertions.assertThat(wydarzenie.getListaUczestnikow()).contains(uczestnik);
        assertions.assertAll();
    }

    @Test
    public void addUczestnik() {
        //given
        wydarzenie.getListaUczestnikow().clear();
        //when
        boolean added = wydarzenie.addUczestnik(uczestnik);
        //then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(added).isTrue();
        assertions.assertThat(wydarzenie.getListaUczestnikow()).contains(uczestnik);
        assertions.assertAll();
    }

    @Test
    public void removeUczestnik() {
        //given
        wydarzenie.addUczestnik(uczestnik);
        //when
        boolean removed = wydarzenie.removeUczestnik(uczestnik);
        //then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(removed).isTrue();
        assertions.assertThat(wydarzenie.getListaUczestnikow()).isEmpty();
        assertions.assertAll();
    }

    @Test
    public void removeUczestnikByPhoneAndMail() {
        //given
        wydarzenie.addUczestnik(uczestnik);
        //when
        boolean removed = wydarzenie.removeUczestnik(uczestnik.getTelefon(), uczestnik.getMail());
        //then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(removed).isTrue();
        assertions.assertThat(wydarzenie.getListaUczestnikow()).isEmpty();
        assertions.assertAll();
    }
}