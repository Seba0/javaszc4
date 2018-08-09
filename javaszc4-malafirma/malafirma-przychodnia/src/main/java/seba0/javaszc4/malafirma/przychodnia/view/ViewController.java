package seba0.javaszc4.malafirma.przychodnia.view;

import seba0.javaszc4.interfaces.cli.CLIFormValues;
import seba0.javaszc4.interfaces.cli.CommandLineInterface;
import seba0.javaszc4.interfaces.cui.canvas.ViewCanvas;
import seba0.javaszc4.interfaces.cui.canvas.ViewCanvasImpl;
import seba0.javaszc4.interfaces.cui.components.FrameView;
import seba0.javaszc4.interfaces.cui.components.LabelView;
import seba0.javaszc4.interfaces.cui.components.TableView;
import seba0.javaszc4.interfaces.cui.components.ViewContainer;
import seba0.javaszc4.malafirma.przychodnia.pracownicy.Lekarz;
import seba0.javaszc4.malafirma.przychodnia.pracownicy.LekarzManager;
import seba0.javaszc4.malafirma.przychodnia.pracownicy.Pacjent;
import seba0.javaszc4.malafirma.przychodnia.pracownicy.Wizyta;
import seba0.javaszc4.malafirma.przychodnia.view.forms.FormFiltrWizyty;
import seba0.javaszc4.malafirma.przychodnia.view.forms.FormLekarz;
import seba0.javaszc4.malafirma.przychodnia.view.forms.FormPacjent;
import seba0.javaszc4.malafirma.przychodnia.view.forms.FormWizyta;
import seba0.javaszc4.malafirma.utils.StringUtils;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Queue;
import seba0.javaszc4.malafirma.utils.PESELUtils;

public final class ViewController {

    private static final CommandLineInterface CLI = new CommandLineInterface();

    private static final DateFormat FORMAT = new SimpleDateFormat("yy-MM-dd HH:mm");

    private ViewController() {
    }

    private static ViewType showLekarze(ViewCanvas canvas) {
        FrameView frame = new FrameView("Lekarze");

        TableView tableView = new TableView(frame)
                .appendColumn("Id")
                .appendColumn("Imie", 20)
                .appendColumn("Nazwisko", 20)
                .appendColumn("Pesel", 11)
                .appendColumn("Telefon", 9)
                .appendColumn("Adress")
                .appendColumn("Stanowisko")
                .appendColumn("Dział");
        tableView.setHeight(-1);

        Collection<Lekarz> lekarze = LekarzManager.getLekarzy();
        lekarze.stream().forEach((lekarz) -> {
            tableView.addRow(
                    lekarz.getId(),
                    lekarz.getImie(),
                    lekarz.getNazwisko(),
                    lekarz.getPesel(),
                    lekarz.getTelefon(),
                    lekarz.getAdres(),
                    lekarz.getStanowisko(),
                    lekarz.getDzial()
            );
        });

        createMenu(frame, "Dodaj", "Usuń", "Wizyty", "Pacjenci", "Wyjście");

        frame.draw(canvas);
        CLI.println(canvas);
        switch (selectedOption(5)) {
            case 1:
                return ViewType.DODAJ_LEKARZA;
            case 2:
                return ViewType.USUN_LEKARZA;
            case 3:
                return ViewType.LISTA_WIZYT;
            case 4:
                return ViewType.LISTA_PACJENTOW;
            default:
                return ViewType.ZAKONCZ;
        }
    }

    private static ViewType showPacjenci(ViewCanvas canvas) {
        FrameView frame = new FrameView("Pacjenci");

        TableView tableView = new TableView(frame)
                .appendColumn("Id")
                .appendColumn("Imie")
                .appendColumn("Nazwisko")
                .appendColumn("Pesel", 11)
                .appendColumn("Telefon", 9)
                .appendColumn("Adress")
                .appendColumn("Lekarz");
        tableView.setHeight(-1);

        Collection<Pacjent> pacjenci = LekarzManager.getPacjenci();
        for (Pacjent pacjent : pacjenci) {
            tableView.addRow(
                    pacjent.getId(),
                    pacjent.getImie(),
                    pacjent.getNazwisko(),
                    pacjent.getPesel(),
                    pacjent.getTelefon(),
                    pacjent.getAdres(),
                    pacjent.getLekarz()
            );
        }

        createMenu(frame, "Dodaj", "Usuń", "Wizyty", "Lekarze", "Wyjście");

        frame.draw(canvas);
        CLI.println(canvas);
        switch (selectedOption(5)) {
            case 1:
                return ViewType.DODAJ_PACJENTA;
            case 2:
                return ViewType.USUN_PACJENTA;
            case 3:
                return ViewType.LISTA_WIZYT;
            case 4:
                return ViewType.LISTA_LEKARZY;
            default:
                return ViewType.ZAKONCZ;
        }
    }

    private static ViewType showWizyty(ViewCanvas canvas) {
        FrameView frame = new FrameView("Wizyty");

        TableView tableView = new TableView(frame)
                .appendColumn("Id")
                .appendColumn("Data wizyty", 14)
                .appendColumn("Pacjent")
                .appendColumn("Lekarz");
        tableView.setHeight(-1);

        Collection<Wizyta> wizyty = LekarzManager.getWizyty();
        for (Wizyta wizyta : wizyty) {
            tableView.addRow(
                    wizyta.getId(),
                    FORMAT.format(wizyta.getData()),
                    wizyta.getPacjent(),
                    wizyta.getLekarz()
            );
        }

        createMenu(frame, "Dodaj", "Usuń", "Filtruj", "Pacjenci", "Lekarze", "Wyjście");

        frame.draw(canvas);
        CLI.println(canvas);
        switch (selectedOption(5)) {
            case 1:
                return ViewType.DODAJ_WIZYTE;
            case 2:
                return ViewType.USUN_WIZYTE;
            case 3:
                return ViewType.FILTR_WIZYTY;
            case 4:
                return ViewType.LISTA_PACJENTOW;
            case 5:
                return ViewType.LISTA_LEKARZY;
            default:
                return ViewType.ZAKONCZ;
        }
    }

    private static ViewType showWizyty(ViewCanvas canvas, Lekarz lekarz) {
        FrameView frame = new FrameView("Wizyty lekarza: " + lekarz);

        TableView tableView = new TableView(frame)
                .appendColumn("Id")
                .appendColumn("Data wizyty", 14)
                .appendColumn("Pacjent");
        tableView.setHeight(-1);

        Queue<Wizyta> wizyty = LekarzManager.getWizyty(lekarz);
        while (!wizyty.isEmpty()) {
            Wizyta wizyta = wizyty.poll();
            tableView.addRow(
                    wizyta.getId(),
                    FORMAT.format(wizyta.getData()),
                    wizyta.getPacjent()
            );
        }

        createMenu(frame, "Dodaj", "Usuń", "Wszystkie", "Pacjenci", "Lekarze", "Wyjście");

        frame.draw(canvas);
        CLI.println(canvas);
        switch (selectedOption(5)) {
            case 1:
                return ViewType.DODAJ_WIZYTE;
            case 2:
                return ViewType.USUN_WIZYTE;
            case 3:
                return ViewType.LISTA_WIZYT;
            case 4:
                return ViewType.LISTA_PACJENTOW;
            case 5:
                return ViewType.LISTA_LEKARZY;
            default:
                return ViewType.ZAKONCZ;
        }
    }

    private static ViewType showWizyty(ViewCanvas canvas, Pacjent pacjent) {
        FrameView frame = new FrameView("Wizyty pacjenta: " + pacjent);

        TableView tableView = new TableView(frame)
                .appendColumn("Id")
                .appendColumn("Data wizyty", 14)
                .appendColumn("Lekarz");
        tableView.setHeight(-1);

        Queue<Wizyta> wizyty = LekarzManager.getWizyty(pacjent);
        while (!wizyty.isEmpty()) {
            Wizyta wizyta = wizyty.poll();
            tableView.addRow(
                    wizyta.getId(),
                    FORMAT.format(wizyta.getData()),
                    wizyta.getLekarz()
            );
        }

        createMenu(frame, "Dodaj", "Usuń", "Wszystkie", "Pacjenci", "Lekarze", "Wyjście");

        frame.draw(canvas);
        CLI.println(canvas);
        switch (selectedOption(5)) {
            case 1:
                return ViewType.DODAJ_WIZYTE;
            case 2:
                return ViewType.USUN_WIZYTE;
            case 3:
                return ViewType.LISTA_WIZYT;
            case 4:
                return ViewType.LISTA_PACJENTOW;
            case 5:
                return ViewType.LISTA_LEKARZY;
            default:
                return ViewType.ZAKONCZ;
        }
    }

    private static void createMenu(FrameView frame, String... options) {
        ViewContainer container = new ViewContainer(frame, false);
        container.setHeight(1);
        for (int i = 0; i < options.length; i++) {
            new LabelView(container, (i + 1) + ": " + options[i]).setHeight(1);
        }
    }

    private static int selectedOption(int last) {
        while (true) {
            CLI.print("Podaj numer opcji [1-" + last + "]: ");
            int opcja = CLI.nextInt();
            if (opcja < 1 || opcja > last) {
                CLI.println("Wybrano niepoprawny numer opcji");
            } else {
                return opcja;
            }
        }
    }

    public static void init(String[] args) {
        ViewCanvas canvas = new ViewCanvasImpl(100, 30, StandardCharsets.UTF_8);
        ViewType type = ViewType.LISTA_WIZYT;
        long id = -1;
        String tmp;
        Lekarz lekarz = null;
        Pacjent pacjent = null;
        do {
            try {
                canvas.clear();
                switch (type) {
                    default:
                    case LISTA_LEKARZY:
                        type = showLekarze(canvas);
                        break;
                    case LISTA_PACJENTOW:
                        type = showPacjenci(canvas);
                        break;
                    case LISTA_WIZYT:
                        type = showWizyty(canvas);
                        break;
                    case LISTA_WIZYT_LEKARZA:
                        if (lekarz == null) {
                            type = ViewType.LISTA_WIZYT;
                            break;
                        }
                        type = showWizyty(canvas, lekarz);
                        break;
                    case LISTA_WIZYT_PACJENTA:
                        if (pacjent == null) {
                            type = ViewType.LISTA_WIZYT;
                            break;
                        }
                        pacjent = LekarzManager.getPacjent(id);
                        type = showWizyty(canvas, pacjent);
                        break;
                    case FILTR_WIZYTY:
                        type = ViewType.LISTA_WIZYT;
                        CLIFormValues<FormFiltrWizyty> formFiltrWizyt = CLI.printForm(FormFiltrWizyty.class);
                        if (formFiltrWizyt == null) {
                            break;
                        }
                        tmp = formFiltrWizyt.getValue(FormFiltrWizyty.ID_PESEL);
                        if (!StringUtils.isNumeric(tmp)) {
                            break;
                        }
                        id = Long.parseUnsignedLong(tmp);
                        if (PESELUtils.isPESEL(tmp)) {
                            pacjent = LekarzManager.getPacjent(id);
                            if (pacjent != null) {
                                type = ViewType.LISTA_WIZYT_PACJENTA;
                                break;
                            }
                        }
                        lekarz = LekarzManager.getLekarz(id);
                        if (lekarz != null) {
                            type = ViewType.LISTA_WIZYT_LEKARZA;
                        }
                        break;
                    case USUN_LEKARZA:
                        type = ViewType.LISTA_LEKARZY;
                        CLI.println("Do lekarz nie mogą być przypisani pacjenci i wizyty");
                        CLI.print("Podaj id lekarza do usunięcia lub 0 aby anulować.\n\tId pekarza: ");
                        id = CLI.nextLong();
                        if (id > 0) {
                            if (LekarzManager.deleteLekarz(id)) {
                                CLI.println("Lekarz został usunięty");
                            } else {
                                CLI.println("Nie udało się usunąć lekarza");
                            }
                        }
                        break;
                    case USUN_PACJENTA:
                        type = ViewType.LISTA_PACJENTOW;
                        CLI.println("Do pacjenta nie mogą być przypisane wizyty");
                        CLI.print("Podaj id pacjenta do usunięcia lub 0 aby anulować.\n\tId pacjenta: ");
                        id = CLI.nextLong();
                        if (id > 0) {
                            if (LekarzManager.deletePacjent(id)) {
                                CLI.println("Pacjent zostało usunięty");
                            } else {
                                CLI.println("Nie udało się usunąć pacjenta");
                            }
                        }
                        break;
                    case USUN_WIZYTE:
                        type = ViewType.USUN_WIZYTE;
                        CLI.println("Wizyta musi być z dataą przyszłą");
                        CLI.print("Podaj id wizyty do usunięcia lub 0 aby anulować.\n\tId wizyty: ");
                        id = CLI.nextLong();
                        if (id > 0) {
                            if (LekarzManager.deleteWizyta(id)) {
                                CLI.println("Dział został usunięty");
                            } else {
                                CLI.println("Nie udało się usunąć działu");
                            }
                        }
                        break;
                    case DODAJ_LEKARZA:
                        type = ViewType.LISTA_LEKARZY;
                        CLIFormValues<FormLekarz> formLekarz = CLI.printForm(FormLekarz.class);
                        if (formLekarz == null) {
                            break;
                        }
                        id = Long.parseUnsignedLong(formLekarz.getValue(FormLekarz.ID_PRACOWNIKA));
                        if (LekarzManager.createLekarz(id) == null) {
                            CLI.println("Nie udało się dodać lekarza");
                        }
                        break;
                    case DODAJ_PACJENTA:
                        type = ViewType.LISTA_PACJENTOW;
                        CLIFormValues<FormPacjent> formPacjent = CLI.printForm(FormPacjent.class);
                        if (formPacjent == null) {
                            break;
                        }
                        tmp = formPacjent.getValue(FormPacjent.ID_LEKARZA);
                        id = Long.parseUnsignedLong(tmp);
                        lekarz = LekarzManager.getLekarz(id);
                        LekarzManager.createPacjent(
                                formPacjent.getValue(FormPacjent.IMIE),
                                formPacjent.getValue(FormPacjent.NAZWISKO),
                                Long.parseUnsignedLong(formPacjent.getValue(FormPacjent.PESEL)))
                                .telefon(Long.parseUnsignedLong(formPacjent.getValue(FormPacjent.TELEFON)))
                                .adres(formPacjent.getValue(FormPacjent.ADRES))
                                .lekarz(lekarz)
                                .build();
                        break;
                    case DODAJ_WIZYTE:
                        type = ViewType.LISTA_WIZYT;
                        CLIFormValues<FormWizyta> formWizyta = CLI.printForm(FormWizyta.class);
                        if (formWizyta == null) {
                            break;
                        }
                        Date data = FORMAT.parse(formWizyta.getValue(FormWizyta.DATA_WIZYTY));
                        tmp = formWizyta.getValue(FormWizyta.ID_LEKARZA);
                        lekarz = LekarzManager.getLekarz(Long.parseUnsignedLong(tmp));
                        tmp = formWizyta.getValue(FormWizyta.PESEL_PACJENTA);
                        pacjent = LekarzManager.getPacjent(Long.parseUnsignedLong(tmp));
                        LekarzManager.createWizyta(data, pacjent, lekarz);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (type != ViewType.ZAKONCZ);
        CLI.println("Program zakończył działanie...");
    }
}
