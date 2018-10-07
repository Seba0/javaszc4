package seba0.javaszc4.java8.functional.interfaces.function._2;

import seba0.javaszc4.java8.utils.TimeCounter;

import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private final static Pattern USER_PATTERN = Pattern.compile("(?:\\s*(?<firstName>[A-Z][a-z]+)\\s*)(?:,\\s*(?<lastName>[A-Z][a-z]+)\\s*)(?:,\\s*(?<age>[0-9]+)\\s*)", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        TimeCounter.watch(() -> {
            Function<String, Optional<User>> userCreator = name -> {
                Matcher matcher = USER_PATTERN.matcher(name);
                if (matcher.matches()) {
                    String firstName = matcher.group("firstName");
                    String lastName = matcher.group("lastName");
                    String age = matcher.group("age");
                    return Optional.of(new User(firstName, lastName, Short.parseShort(age)));
                }
                return Optional.empty();
            };
            userCreator.apply("Sebastian,Kubiak");
        });
    }
}
