package javaszc4.malafirma.view;

import java.util.Arrays;

public class ViewCanvasImpl implements ViewCanvas {
    private final char[][] map;

    public ViewCanvasImpl(int width, int height) {
        map = new char[height][width];
    }

    @Override
    public int getHeight() {
        return map.length;
    }

    @Override
    public int getWidth() {
        if (map.length > 0) {
            return map[0].length;
        }
        return 0;
    }

    @Override
    public void clear() {
        for (char[] row : map) {
            Arrays.fill(row, ' ');
        }
    }

    @Override
    public void drawString(int x, int y, CharSequence value) {
        char[] row = map[y];
        for (int i = 0; i < value.length(); i++) {
            row[i + x] = value.charAt(i);
        }
    }

    @Override
    public void drawChar(int x, int y, char value) {
        map[y][x] = value;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, char value) {
        int deltaX = x2 - x1;
        if (deltaX == 0) {
            for (int y = y1; y < y2; y++) {
                drawChar(x1, y, value);
            }
        } else {
            int deltaY = y2 - y1;
            float deltaErr = Math.abs((float) deltaY / (float) deltaX);
            float error = 0;
            int y = y1;
            for (int x = x1; x < x2; x++) {
                drawChar(x, y, value);
                error += deltaErr;
                if (error >= 0.5) {
                    y += Math.signum(deltaY) * 1;
                    error -= 1;
                }
            }
        }
    }

    @Override
    public ViewCanvas subCanvas(int x, int y, int width, int height) {
        return new ViewSubCanvas(this, x, y, width, height);
    }
}
