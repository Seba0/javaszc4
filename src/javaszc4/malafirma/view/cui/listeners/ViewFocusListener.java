package javaszc4.malafirma.view.cui.listeners;

import java.util.EventListener;

/**
 *
 * @author sebastian
 */
public interface ViewFocusListener extends EventListener {

    public boolean onFocusChanged(boolean granted);

    public void onKeyTyped(char key);

}
