package seba0.javaszc4.malafirma.utils;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void isNumericGivenNullExpectFalse() {
        //given
        String value = null;
        //when
        boolean result = StringUtils.isNumeric(value);
        //then
        Assertions
                .assertThat(result)
                .isFalse();
    }

    @Test
    public void isNumericGivenAlaMaKOtaExpectFalse() {
        //given
        String value = "Ala ma Kota";
        //when
        boolean result = StringUtils.isNumeric(value);
        //then
        Assertions
                .assertThat(result)
                .isFalse();
    }

    @Test
    public void isNumericGivenAlaExpectFalse() {
        //given
        String value = "Ala     ";
        //when
        boolean result = StringUtils.isNumeric(value);
        //then
        Assertions
                .assertThat(result)
                .isFalse();
    }

    @Test
    public void isNumericGivenSpacesExpectFalse() {
        //given
        String value = "      ";
        //when
        boolean result = StringUtils.isNumeric(value);
        //then
        Assertions
                .assertThat(result)
                .isFalse();
    }

    @Test
    public void isNumericGiven123ExpectTrue() {
        //given
        String value = "123";
        //when
        boolean result = StringUtils.isNumeric(value);
        //then
        Assertions
                .assertThat(result)
                .isTrue();
    }
}