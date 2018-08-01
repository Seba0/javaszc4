package javaszc4.malafirma.datastore;

import java.io.Externalizable;

public abstract class DataTable implements Externalizable {

    private long id = -1;

    public final long getId() {
        return id;
    }
}
