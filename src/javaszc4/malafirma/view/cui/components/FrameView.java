package javaszc4.malafirma.view.cui.components;

import java.nio.charset.StandardCharsets;
import javaszc4.malafirma.view.cui.canvas.ViewCanvas;

public class FrameView extends ViewContainer {

    private String title;

    public FrameView(ViewContainer parent) {
        super(parent, true);
    }

    public FrameView(String title) {
        super(null, true);
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void draw(ViewCanvas canvas) {
        int w = canvas.getWidth();
        int h = canvas.getHeight();
        int xStart = 0;
        int xEnd = w - 1;
        int yStart = 0;
        int yEnd = h - 1;

        if (w < 1 || h < 1) {
        } else if (w == 1 && h == 1) {
            canvas.drawChar(xStart, yStart, canvas.getCharset() == StandardCharsets.UTF_8 ? '■' : '+');
        } else if (w == 1) {
            canvas.drawChar(xStart, yStart, canvas.getCharset() == StandardCharsets.UTF_8 ? '█' : '+');
            for (int y = 1; y < h - 1; y++) {
                canvas.drawChar(xStart, y, canvas.getCharset() == StandardCharsets.UTF_8 ? '█' : '|');
            }
            canvas.drawChar(xStart, h - 1, canvas.getCharset() == StandardCharsets.UTF_8 ? '█' : '+');
        } else if (h == 1) {
            canvas.drawChar(0, 0, canvas.getCharset() == StandardCharsets.UTF_8 ? '█' : '+');
            for (int x = 1; x < w - 1; x++) {
                if (x > 2 && x < w - 2 && title != null && x - 3 < title.length()) {
                    canvas.drawChar(x, 0, title.charAt(x - 3));
                } else {
                    canvas.drawChar(x, 0, canvas.getCharset() == StandardCharsets.UTF_8 ? '█' : '-');
                }
            }
            canvas.drawChar(w - 1, 0, canvas.getCharset() == StandardCharsets.UTF_8 ? '█' : '+');
        } else {
            canvas.drawChar(xStart, yStart, canvas.getCharset() == StandardCharsets.UTF_8 ? '▛' : '+');
            canvas.drawChar(xEnd, yStart, canvas.getCharset() == StandardCharsets.UTF_8 ? '▜' : '+');
            canvas.drawChar(xStart, yEnd, canvas.getCharset() == StandardCharsets.UTF_8 ? '▙' : '+');
            canvas.drawChar(xEnd, yEnd, canvas.getCharset() == StandardCharsets.UTF_8 ? '▟' : '+');
            for (int y = yStart + 1; y < yEnd; y++) {
                canvas.drawChar(xStart, y, canvas.getCharset() == StandardCharsets.UTF_8 ? '▌' : '|');
                canvas.drawChar(xEnd, y, canvas.getCharset() == StandardCharsets.UTF_8 ? '▐' : '|');
            }

            for (int x = xStart + 1; x < xEnd; x++) {
                if (title != null && xStart + 2 == x && x - 3 < title.length()) {
                    canvas.drawChar(x, yStart, canvas.getCharset() == StandardCharsets.UTF_8 ? '▌' : '-');
                } else if (title != null && xStart + 2 + title.length() + 1 == x && x - 4 < title.length()) {
                    canvas.drawChar(x, yStart, canvas.getCharset() == StandardCharsets.UTF_8 ? '▐' : '-');
                } else if (x > 2 && x < w - 2 && title != null && x - 3 < title.length()) {
                    canvas.drawChar(x, yStart, title.charAt(x - 3));
                } else {
                    canvas.drawChar(x, yStart, canvas.getCharset() == StandardCharsets.UTF_8 ? '▀' : '-');
                }
                canvas.drawChar(x, yEnd, canvas.getCharset() == StandardCharsets.UTF_8 ? '▄' : '-');
            }

            ViewCanvas subCanvas = canvas.subCanvas(1, 1, w - 2, h - 2);
            super.draw(subCanvas);
        }
    }
}
