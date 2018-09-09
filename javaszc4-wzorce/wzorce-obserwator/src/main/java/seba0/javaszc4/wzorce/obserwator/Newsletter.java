package seba0.javaszc4.wzorce.obserwator;

public class Newsletter {
    private final String body;

    public Newsletter(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return body;
    }
}
