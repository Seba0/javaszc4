package seba0.javaszc4.wzorce.stan.delivery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(Parameterized.class)
public class StateTest {

    private final Package pkg;
    private final PackageState state;
    private final String printStatusResult;
    private final Class<? extends PackageState> nextType;
    private final Class<? extends PackageState> prevType;

    public StateTest(PackageState state, Class<? extends PackageState> nextType, Class<? extends PackageState> prevType, String printStatusResult) {
        this.nextType = nextType;
        this.prevType = prevType;
        this.pkg = new Package();
        this.state = state;
        this.printStatusResult = printStatusResult;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new OrderedState(), DeliveredState.class, OrderedState.class, "Package ordered, not delivered to the office yet."},
                {new DeliveredState(), ReceivedState.class, OrderedState.class, "Package delivered to post office, not received yet."},
                {new ReceivedState(), OrderedState.class, DeliveredState.class, "Package received by client!"}
        });
    }

    @Test
    public void testNextState() {
        // given

        // when
        state.next(pkg);

        // then
        assertEquals(nextType, pkg.getState().getClass());
    }

    @Test
    public void testPrev() {
        // given

        // when
        state.prev(pkg);

        // then
        assertEquals(prevType, pkg.getState().getClass());
    }

    @Test
    public void testPrintStatus() {
        // given
        PrintStream stream = mock(PrintStream.class);
        System.setOut(stream);

        // when
        state.printStatus();

        // then
        verify(stream).println(printStatusResult);
    }
}