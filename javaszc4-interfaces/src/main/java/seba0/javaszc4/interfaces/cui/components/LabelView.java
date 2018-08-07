package seba0.javaszc4.interfaces.cui.components;

import seba0.javaszc4.interfaces.cui.canvas.ViewCanvas;

/**
 *
 * @author sebastian
 */
public class LabelView extends View {

    private String text;

    public LabelView(ViewContainer parent, int width) {
        super(parent);
        this.text = "";
        setWidth(width);
        setHeight(1);
    }

    public LabelView(ViewContainer parent, String text) {
        super(parent);
        this.text = text;
        setWidth(-1);
        setHeight(1);
    }

    public LabelView(ViewContainer parent, String text, int width) {
        super(parent);
        this.text = text;
        setWidth(width);
        setHeight(1);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public void draw(ViewCanvas canvas) {
        canvas.drawString(0, 0, text);
    }

}
