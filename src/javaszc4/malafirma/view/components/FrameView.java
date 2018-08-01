package javaszc4.malafirma.view.components;

import javaszc4.malafirma.view.ViewCanvas;

import java.util.ArrayList;
import java.util.List;

public class FrameView extends View {

    private String title;
    private final List<View> childs = new ArrayList<>();

    public FrameView(View parent) {
        super(parent);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        draw();
    }

    public boolean add(View view) {
        boolean added = childs.add(view);
        if (added) {
            draw();
        }
        return added;
    }

    public boolean remove(View view) {
        boolean removed = childs.remove(view);
        if (removed) {
            draw();
        }
        return removed;
    }

    @Override
    public void draw(ViewCanvas canvas) {

    }
}
