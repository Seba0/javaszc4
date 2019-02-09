package seba0.javaszc4.wzorce.obiekt.rozszerzenia;

import lombok.experimental.ExtensionMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtensionMethod(Extensions.class)
public class ExtensionExample {
    public static void main(String[] args) {
        List<String> examples = new ArrayList<String>();
        System.out.println(examples.getItem(10, "null object"));

        Map<Integer, String> map = new HashMap<>();
        System.out.println(map.getItem(10, "null ff"));

    }
}
