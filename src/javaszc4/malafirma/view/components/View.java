package javaszc4.malafirma.view.components;

import javaszc4.malafirma.view.ViewCanvas;

public abstract class View {

    private View parent;
    private int x;
    private int y;
    private int height;
    private int width;

    public View(View parent) {
        this.parent = parent;
    }

    public View getParent() {
        return parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public abstract void draw(ViewCanvas canvas);
}
