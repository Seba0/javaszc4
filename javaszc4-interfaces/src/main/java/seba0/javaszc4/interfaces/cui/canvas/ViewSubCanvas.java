package seba0.javaszc4.interfaces.cui.canvas;

import java.nio.charset.Charset;

class ViewSubCanvas implements ViewCanvas {

    private final ViewCanvas parent;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    ViewSubCanvas(ViewCanvas parent, int x, int y, int width, int height) {
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public Charset getCharset() {
        return parent.getCharset();
    }

    public ViewCanvas getParent() {
        return parent;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void clear() {
        int rX = x < 0 ? 0 : x;
        int rY = y < 0 ? 0 : y;
        int rW = x + width > parent.getHeight() ? parent.getHeight() : x + width;
        int rH = y + height > parent.getHeight() ? parent.getHeight() : y + height;

        for (int i = rX; i < rW; i++) {
            for (int j = rY; j < rH; j++) {
                parent.drawChar(i, j, ' ');
            }
        }
    }

    @Override
    public void drawString(int x, int y, CharSequence value) {
        for (int i = 0; i < value.length(); i++) {
            drawChar(x + i, y, value.charAt(i));
        }
    }

    @Override
    public void drawChar(int x, int y, char value) {
        int rX = this.x + x;
        int rY = this.y + y;
        int rW = this.x + width > parent.getWidth() ? parent.getWidth() : this.x + width;
        int rH = this.y + height > parent.getHeight() ? parent.getHeight() : this.y + height;
        if (rX >= 0 && rX < rW
                && rY >= 0 && rY < rH) {
            parent.drawChar(rX, rY, value);
        }
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, char value) {
        ViewCanvasUtils.drawLine(this, x1, y1, x2, y2, value);
    }

    @Override
    public ViewCanvas subCanvas(int x, int y, int width, int height) {
        return ViewCanvasUtils.subCanvas(this, x, y, width, height);
    }
}
