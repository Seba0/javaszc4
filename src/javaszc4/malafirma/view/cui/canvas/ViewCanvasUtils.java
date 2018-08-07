package javaszc4.malafirma.view.cui.canvas;

/**
 *
 * @author sebastian
 */
public final class ViewCanvasUtils {

    private ViewCanvasUtils() {
    }

    public static void drawLine(ViewCanvas canvas, int x1, int y1, int x2, int y2, char value) {
        int deltaX = x2 - x1;
        if (deltaX == 0) {
            for (int y = y1; y < y2; y++) {
                canvas.drawChar(x1, y, value);
            }
        } else {
            int deltaY = y2 - y1;
            float deltaErr = Math.abs((float) deltaY / (float) deltaX);
            float error = 0;
            int y = y1;
            for (int x = x1; x < x2; x++) {
                canvas.drawChar(x, y, value);
                error += deltaErr;
                if (error >= 0.5) {
                    y += Math.signum(deltaY) * 1;
                    error -= 1;
                }
            }
        }
    }

    public static ViewCanvas subCanvas(ViewCanvas canvas, int x, int y, int width, int height) {
        return new ViewSubCanvas(canvas, x, y, width, height);
    }
}
