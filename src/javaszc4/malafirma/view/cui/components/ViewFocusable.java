package javaszc4.malafirma.view.cui.components;

import javaszc4.malafirma.view.cui.ViewFocusManager;
import javaszc4.malafirma.view.cui.listeners.ViewFocusListener;

/**
 *
 * @author sebastian
 */
public abstract class ViewFocusable extends View implements ViewFocusListener {

    public ViewFocusable(ViewContainer parent) {
        super(parent);
        ViewFocusManager.add(this);
    }

}
