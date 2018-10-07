package seba0.javaszc4.java8.functional.interfaces.function._1;

import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Main {
    public static void main(String[] args) {
        DoubleToIntFunction fun1 = val -> (int) val;
        Function<Double, Integer> fun2 = Double::intValue;
        ToIntFunction<Double> fun3 = Double::intValue;
        DoubleFunction<Integer> fun4 = val -> (int) val;

    }
}
