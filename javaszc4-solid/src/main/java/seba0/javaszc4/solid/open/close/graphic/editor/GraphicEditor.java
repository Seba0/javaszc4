package seba0.javaszc4.solid.open.close.graphic.editor;

import java.util.LinkedList;
import java.util.List;

public class GraphicEditor extends Editable {
    private final List<Editable> editables = new LinkedList<>();

    public GraphicEditor build(Editable drawable) {
        editables.add(drawable);
        return this;
    }

    public List<Editable> getDrawables() {
        return editables;
    }

    @Override
    public GraphicEditor draw(Canvas canvas) {
        for (Drawable drawable : editables) {
            drawable.draw(canvas);
        }
        return this;
    }
    
}
