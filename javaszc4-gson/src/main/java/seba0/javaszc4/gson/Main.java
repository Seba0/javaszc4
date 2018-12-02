package seba0.javaszc4.gson;

import com.google.gson.Gson;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Starships starships = new Starships(
                "Death Star",
                "DS-1 Orbital Battle Station",
                "Imperial Department of Military Research, Sienar Fleet Systems",
                "1000000000000",
                "120000",
                Arrays.asList("https://swapi.co/api/films/1/")
        );
        String json = gson.toJson(starships);
        System.out.println(json);

        Starships starships1 = gson.fromJson(
                "{name='Death Star', model='DS-1 Orbital Battle Station', manufacturer='Imperial Department of Military Research, Sienar Fleet Systems', cost_in_credits='1000000000000', length='120000', 'films':['https://swapi.co/api/films/1/']}",
                Starships.class);
        System.out.println(starships1);
    }
}
