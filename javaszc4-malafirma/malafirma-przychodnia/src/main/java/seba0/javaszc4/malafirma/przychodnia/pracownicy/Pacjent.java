package seba0.javaszc4.malafirma.przychodnia.pracownicy;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;
import seba0.javaszc4.malafirma.datastore.DataTable;

public class Pacjent extends DataTable {

    private String imie;
    private String nazwisko;
    private long pesel;
    private long telefon;
    private String adres;
    private Lekarz lekarz;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
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
        out.writeUTF(imie);
        out.writeUTF(nazwisko);
        out.writeLong(pesel);
        out.writeLong(telefon);
        out.writeUTF(adres);
        out.writeObject(lekarz);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setVersion(in.readInt());
        imie = in.readUTF();
        nazwisko = in.readUTF();
        pesel = in.readLong();
        telefon = in.readLong();
        adres = in.readUTF();
        lekarz = (Lekarz) in.readObject();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacjent pacjent = (Pacjent) o;
        return pesel == pacjent.pesel &&
                Objects.equals(imie, pacjent.imie) &&
                Objects.equals(nazwisko, pacjent.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, pesel);
    }

    @Override
    public String toString() {
        return imie + ' ' + nazwisko + " " + pesel;
    }
}
