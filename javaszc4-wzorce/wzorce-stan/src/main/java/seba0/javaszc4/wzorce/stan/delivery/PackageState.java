package seba0.javaszc4.wzorce.stan.delivery;

public interface PackageState {
    void next(Package pkg);

    void prev(Package pkg);

    void printStatus();
}
