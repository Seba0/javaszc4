package seba0.javaszc4.tdd.wydarzenia;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UczestnikTest {

    @Test
    public void create() {
        //given
        String imie = "Jan";
        String nazwisko = "Kowalski";
        String mail = "jan.kowalski@example.com";

        //when
        Uczestnik uczestnik = new Uczestnik(imie, nazwisko, mail);

        //then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(uczestnik)
                .isNotNull();
        assertions.assertThat(uczestnik.getImie())
                .isNotNull()
                .isEqualTo(imie);
        assertions.assertThat(uczestnik.getNazwisko())
                .isNotNull()
                .isEqualTo(nazwisko);
        assertions.assertThat(uczestnik.getMail())
                .isNotNull()
                .isEqualTo(mail);
        assertions.assertAll();
    }

    @Test
    public void equalsTrueIfSameMail() {
        //given
        Uczestnik uczestnik1 = new Uczestnik("Jan", "Kowalski", "jan.kowalski@example.com");
        Uczestnik uczestnik2 = new Uczestnik("Mirek", "Mazowiecki", "jan.kowalski@example.com");

        //when
        boolean result = uczestnik1.equals(uczestnik2);

        //then
        assertThat(result)
                .isNotNull()
                .isTrue();
    }

    @Test
    public void equalsFalseIfDiffrentMail() {
        //given
        Uczestnik uczestnik1 = new Uczestnik("Mirek", "Mazowiecki", "jan.kowalski@example.com");
        Uczestnik uczestnik2 = new Uczestnik("Mirek", "Mazowiecki", "jkowalski@example.com");

        //when
        boolean result = uczestnik1.equals(uczestnik2);

        //then
        assertThat(result)
                .isNotNull()
                .isFalse();
    }

    @Test
    public void hashTrueIfSameMail() {
        //given
        Uczestnik uczestnik1 = new Uczestnik("Jan", "Kowalski", "jan.kowalski@example.com");
        Uczestnik uczestnik2 = new Uczestnik("Mirek", "Mazowiecki", "jan.kowalski@example.com");

        //when
        int hashUczestnik1 = uczestnik1.hashCode();
        int hashUczestnik2 = uczestnik2.hashCode();

        //then
        assertThat(hashUczestnik1)
                .isNotNull()
                .isEqualTo(hashUczestnik2);
    }

    @Test
    public void hashFalseIfDiffrentMail() {
        //given
        Uczestnik uczestnik1 = new Uczestnik("Mirek", "Mazowiecki", "jan.kowalski@example.com");
        Uczestnik uczestnik2 = new Uczestnik("Mirek", "Mazowiecki", "jkowalski@example.com");

        //when
        int hashUczestnik1 = uczestnik1.hashCode();
        int hashUczestnik2 = uczestnik2.hashCode();

        //then
        assertThat(hashUczestnik1)
                .isNotNull()
                .isNotEqualTo(hashUczestnik2);
    }
}
