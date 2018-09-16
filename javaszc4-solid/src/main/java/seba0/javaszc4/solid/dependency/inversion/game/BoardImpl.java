package seba0.javaszc4.solid.dependency.inversion.game;

import java.util.Arrays;

public class BoardImpl {

    private final Figure[][] board;

    public BoardImpl(int width, int height) {
        this.board = new Figure[height][width];
        for (Figure[] figures : board) {
            Arrays.fill(figures, Figure.EMPTY);
        }
    }

    public boolean set(int x, int y, Figure figure) {
        if (figure == null || get(x, y) == null) {
            return false;
        }
        board[y][x] = figure;
        return true;
    }

    public Figure get(int x, int y) {
        return board[y][x];
    }
}
