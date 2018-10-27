package seba0.javaszc4.java8.lambda._3;

public class Main {
    public static void main(String[] args) {
        UserCreator creator = User::new;
        User user = creator.createUser("Jan", "Kowalski");
    }
}
