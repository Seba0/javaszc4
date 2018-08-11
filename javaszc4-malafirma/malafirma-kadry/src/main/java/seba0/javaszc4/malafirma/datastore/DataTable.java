package seba0.javaszc4.malafirma.datastore;

import java.io.Externalizable;

public abstract class DataTable implements Externalizable {

    private long id = -1;
    private int version = 1;

    public final long getId() {
        return id;
    }

    protected final int getVersion() {
        return version;
    }

    protected final void setVersion(int version) {
        this.version = version;
    }
}
