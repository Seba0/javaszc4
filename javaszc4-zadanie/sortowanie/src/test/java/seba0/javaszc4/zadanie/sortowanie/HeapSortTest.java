package seba0.javaszc4.zadanie.sortowanie;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class HeapSortTest {

    private Sort sort;
    private Integer[] ints = {4, 3, 5, 2, 1, 0, 8};
    private final Integer[] outs = new Integer[]{0, 1, 2, 3, 4, 5, 8};
    private Integer[] ints100;
    private Integer[] outs100;

    @Before
    public void prepare() {
        sort = new HeapSort();
        ints100 = new Integer[100];
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            ints100[i] = r.nextInt(100);
        }
        outs100 = Arrays.copyOf(ints100, 100);
        Arrays.sort(outs100);
    }

    @Test
    public void testSort() {
        System.out.println("Input: " + Arrays.toString(ints));
        sort.sort(ints);
        System.out.println("Output: " + Arrays.toString(ints));
        System.out.println("Requir: " + Arrays.toString(outs));
        assertArrayEquals(outs, ints);
    }

    @Test
    public void testSort100() {
        System.out.println("Input: " + Arrays.toString(ints100));
        sort.sort(ints100);
        System.out.println("Output: " + Arrays.toString(ints100));
        System.out.println("Requir: " + Arrays.toString(outs100));
        assertArrayEquals(outs100, ints100);
    }
}
