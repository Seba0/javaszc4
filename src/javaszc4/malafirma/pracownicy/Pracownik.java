package javaszc4.malafirma.pracownicy;

import javaszc4.malafirma.datastore.DataTable;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Pracownik extends DataTable {

    private String imie;
    private String nazwisko;
    private long pesel;
    private long telefon;
    private String adres;
    private Stanowisko stanowisko;
    private Dzial dzial;

    public Pracownik() {
    }

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

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Dzial getDzial() {
        return dzial;
    }

    public void setDzial(Dzial dzial) {
        this.dzial = dzial;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(1);
        out.writeUTF(imie);
        out.writeUTF(nazwisko);
        out.writeLong(pesel);
        out.writeLong(telefon);
        out.writeUTF(adres);
        out.writeObject(stanowisko);
        out.writeObject(dzial);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readInt();
        imie = in.readUTF();
        nazwisko = in.readUTF();
        pesel = in.readLong();
        telefon = in.readLong();
        adres = in.readUTF();
        stanowisko = (Stanowisko) in.readObject();
        dzial = (Dzial) in.readObject();
    }
}
