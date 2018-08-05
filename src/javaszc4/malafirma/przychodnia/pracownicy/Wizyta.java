package javaszc4.malafirma.przychodnia.pracownicy;

import javaszc4.malafirma.datastore.DataTable;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;
import java.util.Objects;

public class Wizyta extends DataTable implements Comparable<Wizyta> {

    private Date data = new Date();
    private Pacjent pacjent;
    private Lekarz lekarz;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = Objects.requireNonNull(data);
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getVersion());
        out.writeLong(data.getTime());
        out.writeObject(lekarz);
        out.writeObject(pacjent);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setVersion(in.readInt());
        data = new Date(in.readLong());
        lekarz = (Lekarz) in.readObject();
        pacjent = (Pacjent) in.readObject();
    }

    @Override
    public int compareTo(Wizyta o) {
        return data.compareTo(o.getData());
    }
}
