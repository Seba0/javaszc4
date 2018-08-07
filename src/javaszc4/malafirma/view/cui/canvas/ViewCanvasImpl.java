package javaszc4.malafirma.view.cui.canvas;

import java.nio.charset.Charset;
import java.util.Arrays;

public class ViewCanvasImpl implements ViewCanvas {

    private final char[][] map;
    private final Charset charset;

    public ViewCanvasImpl(int width, int height, Charset charset) {
        map = new char[height][width];
        this.charset = charset;
        clear();
    }

    @Override
    public Charset getCharset() {
        return charset;
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
        for (int y = 0; y < map.length; y++) {
            Arrays.fill(map[y], ' ');
        }
    }

    @Override
    public void drawString(int x, int y, CharSequence value) {
        for (int i = 0; i < value.length(); i++) {
            map[y][i + x] = value.charAt(i);
        }
    }

    @Override
    public void drawChar(int x, int y, char value) {
        map[y][x] = value;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, char value) {
        ViewCanvasUtils.drawLine(this, x1, y1, x2, y2, value);
    }

    @Override
    public ViewCanvas subCanvas(int x, int y, int width, int height) {
        return ViewCanvasUtils.subCanvas(this, x, y, width, height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            sb.append(row).append('\n');
        }
        return sb.toString();
    }
}
