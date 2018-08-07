package javaszc4.malafirma.view.cui.components;

import javaszc4.malafirma.view.cui.canvas.ViewCanvas;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sebastian
 */
public class TableView extends ViewContainer {

    private final List<TableViewColumn> columns = new ArrayList<>();
    private final List<String[]> rows = new ArrayList<>();
    private int rowIndex;

    public TableView(ViewContainer parent) {
        super(parent, false);
    }

    public List<String[]> getRows() {
        return rows;
    }

    public void displayFrom(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getCollumnsCount() {
        return columns.size();
    }

    public TableView appendColumn(String name, int size) {
        columns.add(new TableViewColumn(name, size));
        return this;
    }

    public TableView appendColumn(String name) {
        return appendColumn(name, -1);
    }

    public boolean addRow(Object... cell) {
        String[] row = new String[cell.length];
        for (int i = 0; i < row.length; i++) {
            Object obj = cell[i];
            if (obj != null) {
                if (obj instanceof String) {
                    row[i] = (String) obj;
                } else {
                    row[i] = String.valueOf(cell[i]);
                }
            }
        }
        return rows.add(row);
    }

    private int[] collumnsMaximum() {
        int[] maxs = new int[columns.size()];
        int max = 0;
        for (String[] row : rows) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] != null) {
                    int size = row[i].length();
                    if (size > maxs[i]) {
                        maxs[i] = size;
                    }
                }
            }
        }
        return maxs;
    }

    private void columnsSizes(int[] maxs, int maxSize) {
        boolean update;

        int sizeSum;
        int unsized;

        int unsizedSize;
        do {
            update = false;
            sizeSum = 0;
            unsized = 0;

            for (TableViewColumn column : columns) {
                int size = column.getFixed();
                if (size < 0) {
                    unsized++;
                } else {
                    sizeSum += size;
                }
            }

            unsizedSize = 0;
            if (unsized > 0) {
                unsizedSize = (maxSize - sizeSum) / unsized;
                if (unsizedSize < 0) {
                    unsizedSize = 0;
                }
            }

            for (int i = 0; i < columns.size(); i++) {
                TableViewColumn column = columns.get(i);
                int size = column.getFixed();
                if (size < 0) {
                    if (maxs[i] < unsized) {
                        update = true;
                        column.setFixed(maxs[i]);
                    }
                }
            }
        } while (update);

        TableViewColumn lastUnsized = null;
        for (TableViewColumn column : columns) {
            int size = column.getFixed();
            if (size < 0) {
                column.setFixed(unsizedSize);
                lastUnsized = column;
            }
        }

        int sum = maxSize - (sizeSum + unsizedSize * unsized);
        if (sum > 0 && lastUnsized != null) {
            lastUnsized.setFixed(lastUnsized.getFixed() + sum);
        }
    }

    @Override
    public void draw(ViewCanvas canvas) {
        removeAll();

        int height = canvas.getHeight();
        if (height <= 0) {
            return;
        }
        int[] maxs;
        if (rows.isEmpty()) {
            maxs = new int[columns.size()];
            for (int i = 0; i < maxs.length; i++) {
                TableViewColumn column = columns.get(i);
                if (column.getFixed() < 0) {
                    String title = column.getTitle();
                    if (title != null) {
                        column.setFixed(title.length());
                    }
                }
                maxs[i] = column.getFixed() + 1;
            }
        } else {
            maxs = collumnsMaximum();
        }
        columnsSizes(maxs, canvas.getWidth());
        int x = 0, y = 0;
        for (TableViewColumn column : columns) {
            int fixed = column.getFixed();
            new LabelView(this, column.getTitle(), fixed)
                    .draw(canvas.subCanvas(x, y, fixed, 1));
            x += fixed + 1;
        }
        if (height > 2) {
            y++;
            char c = canvas.getCharset() == StandardCharsets.UTF_8 ? '═' : '=';
            for (x = 0; x < getWidth(); x++) {
                canvas.drawChar(x, y, c);
            }
        }
        int start = rowIndex;
        while (y++ < height && start < rows.size()) {
            String[] row = rows.get(start++);
            x = 0;
            for (int i = 0; i < row.length; i++) {
                String cell = row[i];
                TableViewColumn column = columns.get(i);
                int fixed = column.getFixed();
                if (cell != null && !cell.isEmpty()) {
                    new LabelView(this, cell, fixed)
                            .draw(canvas.subCanvas(x, y, fixed, 1));
                }
                x += fixed + 1;
            }
        }
    }

}
