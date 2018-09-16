package seba0.javaszc4.solid.dependency.inversion.game;

public interface Board<T extends Figure> {

    boolean set(int x, int y, T figure);

    T get(int x, int y);
}
