package javaszc4.malafirma.view.cui;

import java.io.Console;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaszc4.malafirma.view.cui.listeners.ViewFocusListener;

/**
 *
 * @author sebastian
 */
public final class ViewFocusManager {

    private static final LinkedList<ViewFocusListener> LISTENERS = new LinkedList<>();

    private ViewFocusManager() {
    }

    private static Thread thread = null;

    public static boolean add(ViewFocusListener listener) {
        if (LISTENERS.contains(listener)) {
            return false;
        }
        if (thread == null) {
            final Console console = System.console();
            thread = new Thread(() -> {
                try {
                    while (true) {
                        int read = console.reader().read();
                        System.out.println(read);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ViewFocusManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            thread.start();
        }
        return LISTENERS.add(listener);
    }

    public static boolean remove(ViewFocusListener listener) {
        return LISTENERS.remove(listener);
    }

    public static void main(String[] args) {
        Console console = System.console();
        add(null);
    }
}
