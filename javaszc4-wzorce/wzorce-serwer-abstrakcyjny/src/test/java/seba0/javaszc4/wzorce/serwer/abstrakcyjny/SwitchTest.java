package seba0.javaszc4.wzorce.serwer.abstrakcyjny;


import org.junit.Test;

import static org.mockito.Mockito.*;

public class SwitchTest {

    @Test
    void turn_switch_once() {
        // given
        Switchable switchable = mock(Switchable.class);

        Switch s = new Switch(switchable);

        // when
        s.turn();

        // then
        verify(switchable, times(1)).turnOn();
        verify(switchable, times(0)).turnOff();
    }

    @Test
    void turn_switch_twice() {
        // given
        Switchable switchable = mock(Switchable.class);

        Switch s = new Switch(switchable);

        // when
        s.turn();
        s.turn();

        // then
        verify(switchable, times(1)).turnOn();
        verify(switchable, times(1)).turnOff();
    }
}