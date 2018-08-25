package seba0.javaszc4.malafirma.utils;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class PESELUtilsTest {

    @Test
    public void isPESELGivenNullExceptedFalse() {
        //given
        String value = null;
        //when
        boolean result = PESELUtils.isPESEL(value);
        //then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void isPESELGivenabcdExceptedFalse() {
        //given
        String value = "abcd";
        //when
        boolean result = PESELUtils.isPESEL(value);
        //then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void isPESELGiven1234567896543ExceptedFalse() {
        //given
        String value = "1234567896543";
        //when
        boolean result = PESELUtils.isPESEL(value);
        //then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void isPESELGiven90090515836ExceptedTrue() {
        //given
        String value = "90090515836";
        //when
        boolean result = PESELUtils.isPESEL(value);
        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void getDataUrodzeniaGiven90090515836() {
        //given
        String value = "90090515836";
        //when
        Date result = PESELUtils.getDataUrodzenia(value);
        //then
        Calendar instance = Calendar.getInstance();
        instance.set(1990, Calendar.SEPTEMBER, 5);
        Assertions.assertThat(result).isEqualToIgnoringHours(instance.getTime());
    }
}