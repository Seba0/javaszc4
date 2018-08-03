package javaszc4.malafirma.view;

import java.nio.charset.StandardCharsets;
import javaszc4.malafirma.view.cui.canvas.ViewCanvas;
import javaszc4.malafirma.view.cui.canvas.ViewCanvasImpl;
import javaszc4.malafirma.view.cui.components.FrameView;
import javaszc4.malafirma.view.cui.components.LabelView;
import javaszc4.malafirma.view.cui.components.ViewContainer;

public final class ViewController {

    private ViewController() {

    }

    public static void main(String[] args) {
        ViewCanvas canvas = new ViewCanvasImpl(40, 20, StandardCharsets.UTF_8);
        FrameView frame = new FrameView(null);
        frame.setTitle("Pracownicy");

        FrameView subframe = new FrameView(frame);
        subframe.setTitle("Lista");

        FrameView subframe2 = new FrameView(frame);
        subframe2.setTitle("Lista 2");

        ViewContainer container = new ViewContainer(frame, false);
        LabelView labelView = new LabelView(container, "Hello");
        new LabelView(container, "World");
        container.setHeight(labelView.getHeight());

        frame.draw(canvas);
        System.out.println(canvas);
    }
}
