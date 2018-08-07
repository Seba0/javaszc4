package javaszc4.malafirma.pracownicy;

import javaszc4.malafirma.datastore.DataTable;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

public class Stanowisko extends DataTable {

    private String nazwa;
    private String opis;

    public Stanowisko() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(1);
        out.writeUTF(nazwa);
        out.writeUTF(opis);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readInt();
        nazwa = in.readUTF();
        opis = in.readUTF();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stanowisko dzial = (Stanowisko) o;
        return Objects.equals(nazwa, dzial.nazwa) &&
                Objects.equals(opis, dzial.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, opis);
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
