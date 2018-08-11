package seba0.javaszc4.interfaces.cui.canvas;

import java.nio.charset.Charset;

public interface ViewCanvas {

    Charset getCharset();

    int getHeight();

    int getWidth();

    void clear();

    void drawString(int x, int y, CharSequence value);

    void drawChar(int x, int y, char value);

    void drawLine(int x1, int y1, int x2, int y2, char value);

    ViewCanvas subCanvas(int x, int y, int width, int height);
}
