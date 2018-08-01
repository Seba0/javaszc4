package javaszc4.malafirma.view;

public class ViewSubCanvas implements ViewCanvas {

    private final ViewCanvas parent;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public ViewSubCanvas(ViewCanvas parent, int x, int y, int width, int height) {
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                drawChar(x, y, ' ');
            }
        }
    }

    @Override
    public void drawString(int x, int y, CharSequence value) {

    }

    @Override
    public void drawChar(int x, int y, char value) {

    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, char value) {

    }

    @Override
    public ViewCanvas subCanvas(int x, int y, int width, int height) {
        return new ViewSubCanvas(this, x + this.x, y + this.y, width, height);
    }
}
