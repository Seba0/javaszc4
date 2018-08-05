package javaszc4.malafirma.przychodnia.pracownicy;

import javaszc4.malafirma.datastore.DataFilter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;

class WizytaFilter implements DataFilter<Wizyta> {

    private static final DateFormat FORMAT = new SimpleDateFormat("yy-MM-dd HH:mm");
    private final String data;
    private final Pacjent pacjent;

    WizytaFilter(Wizyta wizyta) {
        pacjent = wizyta.getPacjent();
        data = FORMAT.format(wizyta.getData());
    }

    @Override
    public boolean accept(Wizyta object) {
        return data.equals(FORMAT.format(object.getData())) && Objects.equals(pacjent, object.getPacjent());
    }

    @Override
    public int limit() {
        return 1;
    }
}
