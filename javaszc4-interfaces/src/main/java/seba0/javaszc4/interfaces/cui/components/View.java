package seba0.javaszc4.interfaces.cui.components;

import seba0.javaszc4.interfaces.cui.canvas.ViewCanvas;

public abstract class View {

    private ViewContainer parent;
    private int height = -1;
    private int width = -1;

    public View(ViewContainer parent) {
        this.parent = parent;
        if (parent != null) {
            parent.add(this);
        }
    }

    public ViewContainer getParent() {
        return parent;
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
