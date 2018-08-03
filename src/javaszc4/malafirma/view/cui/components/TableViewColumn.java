package javaszc4.malafirma.view.cui.components;

import java.util.Objects;

/**
 * @author sebastian
 */
class TableViewColumn {

    private final String title;
    private final int size;
    private int fixed = -1;

    TableViewColumn(String title, int size) {
        this.title = title;
        this.size = size;
    }

    String getTitle() {
        return title;
    }

    int getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + this.size;
        return hash;
    }

    int getFixed() {
        if (size < 0) {
            return fixed;
        }
        return size;
    }

    void setFixed(int fixed) {
        this.fixed = fixed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TableViewColumn other = (TableViewColumn) obj;
        if (this.size != other.size) {
            return false;
        }
        return Objects.equals(this.title, other.title);
    }

}
