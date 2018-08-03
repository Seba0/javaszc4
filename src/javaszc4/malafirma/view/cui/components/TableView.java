package javaszc4.malafirma.view.cui.components;

import java.util.ArrayList;
import java.util.List;
import javaszc4.malafirma.view.cui.canvas.ViewCanvas;

/**
 *
 * @author sebastian
 */
public class TableView extends View {

    private final TableViewColumn[] columns;
    private final List<String[]> rows = new ArrayList<>();
    private int rowIndex;

    public TableView(ViewContainer parent, TableViewColumn[] columns) {
        super(parent);
        this.columns = columns;
    }

    public List<String[]> getRows() {
        return rows;
    }

    public void displayFrom(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getCollumnsCount() {
        return columns.length;
    }

    private int[] getColumnsSizes(int maxSize) {
        int[] sizes = new int[columns.length];
        int sizeSum = 0;
        int unsized = 0;
        for (int i = 0; i < columns.length; i++) {
            TableViewColumn column = columns[i];
            int size = column.getSize();
            if (size < 0) {
                unsized -= size;
            } else {
                sizeSum += size;
            }
        }
        
        return sizes;
    }

    @Override
    public void draw(ViewCanvas canvas) {
        getColumnsSizes(canvas.getWidth());
    }

}
