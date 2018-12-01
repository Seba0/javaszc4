package seba0.javaszc4.wzorce.pylek.tree;

public class Tree {

    private final Size size;

    public Tree(Size size) {
        this.size = size;
    }

    public void draw() {
        System.out.println("Tree: " + size);
    }
}
