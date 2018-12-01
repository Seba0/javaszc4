package seba0.javaszc4.wzorce.pylek.tree;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    private final Map<Size, Tree> trees = new HashMap<>();

    public Tree getTree(Size size) {
        return trees.computeIfAbsent(size, Tree::new);
    }
}
