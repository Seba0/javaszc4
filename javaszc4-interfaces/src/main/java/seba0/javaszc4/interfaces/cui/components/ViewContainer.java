package seba0.javaszc4.interfaces.cui.components;

import seba0.javaszc4.interfaces.cui.canvas.ViewCanvas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sebastian
 */
public class ViewContainer extends View implements Iterable<View> {

    private final List<View> childs = new ArrayList<>();
    private boolean vertical;

    public ViewContainer(ViewContainer parent, boolean vertical) {
        super(parent);
        this.vertical = vertical;
    }

    boolean add(View view) {
        if (childs.contains(view)) {
            return false;
        }
        return childs.add(view);
    }

    public void removeAll() {
        childs.clear();
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public boolean isVertical() {
        return vertical;
    }

    @Override
    public Iterator<View> iterator() {
        return childs.iterator();
    }

    @Override
    public void draw(ViewCanvas canvas) {
        int w = canvas.getWidth();
        int h = canvas.getHeight();
        int sizeSum = 0;
        int unsized = 0;
        int maxSize = vertical ? h : w;

        View lastUnsized = null;

        for (View v : childs) {
            int size = vertical ? v.getHeight() : v.getWidth();
            if (size < 0) {
                unsized -= size;
                lastUnsized = v;
            } else {
                sizeSum += size;
            }
        }

        int unsizedSize = 0;
        if (unsized > 0) {
            unsizedSize = (maxSize - sizeSum) / unsized;
            if (unsizedSize < 0) {
                unsizedSize = 0;
            }
        }

        for (View v : childs) {
            if (vertical) {
                if (v.getWidth() < 0) {
                    v.setWidth(w);
                }
                if (v.getHeight() < 0) {
                    v.setHeight(unsizedSize * -v.getHeight());
                }
            } else {
                if (v.getWidth() < 0) {
                    v.setWidth(unsizedSize * -v.getWidth());
                }
                if (v.getHeight() < 0) {
                    v.setHeight(h);
                }
            }
        }

        int sum = maxSize - (sizeSum + unsizedSize * unsized);
        if (sum > 0 && lastUnsized != null) {
            if (vertical) {
                lastUnsized.setHeight(lastUnsized.getHeight() + sum);
            } else {
                lastUnsized.setWidth(lastUnsized.getWidth() + sum);
            }
        }

        sizeSum = 0;

        for (View v : childs) {
            if (v.getWidth() > 0 && v.getHeight() > 0) {
                ViewCanvas c;
                if (vertical) {
                    c = canvas.subCanvas(0, sizeSum, v.getWidth(), v.getHeight());
                } else {
                    c = canvas.subCanvas(sizeSum, 0, v.getWidth(), v.getHeight());
                }
                v.draw(c);
                if (vertical) {
                    sizeSum += v.getHeight();
                } else {
                    sizeSum += v.getWidth();
                }
            }
        }

    }
}
