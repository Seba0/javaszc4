package seba0.javaszc4.malafirma.kadry.view;

import seba0.javaszc4.interfaces.cli.CLIFormValues;
import seba0.javaszc4.interfaces.cli.CommandLineInterface;
import seba0.javaszc4.interfaces.cui.canvas.ViewCanvas;
import seba0.javaszc4.interfaces.cui.canvas.ViewCanvasImpl;
import seba0.javaszc4.interfaces.cui.components.FrameView;
import seba0.javaszc4.interfaces.cui.components.LabelView;
import seba0.javaszc4.interfaces.cui.components.TableView;
import seba0.javaszc4.interfaces.cui.components.ViewContainer;
import seba0.javaszc4.malafirma.kadry.pracownicy.Dzial;
import seba0.javaszc4.malafirma.kadry.pracownicy.Pracownik;
import seba0.javaszc4.malafirma.kadry.pracownicy.PracownikManager;
import seba0.javaszc4.malafirma.kadry.pracownicy.Stanowisko;
import seba0.javaszc4.malafirma.kadry.view.form.FormDzial;
import seba0.javaszc4.malafirma.kadry.view.form.FormPracownik;
import seba0.javaszc4.malafirma.kadry.view.form.FormStanowisko;
import seba0.javaszc4.malafirma.utils.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.*;

public final class ViewController {

    private static final CommandLineInterface CLI = new CommandLineInterface();

    private ViewController() {
    }

    private static ViewType showPracownicy(ViewCanvas canvas) {
        FrameView frame = new FrameView("Pracownicy");

        TableView tableView = new TableView(frame)
                .appendColumn("Id")
                .appendColumn("Imie")
                .appendColumn("Nazwisko")
                .appendColumn("Pesel", 11)
                .appendColumn("Telefon", 9)
                .appendColumn("Adress")
                .appendColumn("Stanowisko")
                .appendColumn("Dział");
        tableView.setHeight(-1);

        Collection<Pracownik> pracownicy = PracownikManager.getPracownicy();
        for (Pracownik pracownik : pracownicy) {
            tableView.addRow(
                    pracownik.getId(),
                    pracownik.getImie(),
                    pracownik.getNazwisko(),
                    pracownik.getPesel(),
                    pracownik.getTelefon(),
                    pracownik.getAdres(),
                    pracownik.getStanowisko(),
                    pracownik.getDzial()
            );
        }
        boolean dodajDisabled = PracownikManager.getDzial().isEmpty() || PracownikManager.getStanowisko().isEmpty();
        boolean usunDisabled = pracownicy.isEmpty();
        createMenu(frame, dodajDisabled ? null : "Dodaj", usunDisabled ? null : "Usuń", "Stanowiska", "Działy", "Wyjście");

        frame.draw(canvas);
        CLI.println(canvas);
        List<Integer> disabledList = new ArrayList<>();
        if (dodajDisabled) {
            disabledList.add(1);
        }
        if (usunDisabled) {
            disabledList.add(2);
        }
        switch (selectedOption(5, disabledList)) {
            case 1:
                return ViewType.DODAJ_PRACOWNIKA;
            case 2:
                return ViewType.USUN_PRACOWNIKA;
            case 3:
                return ViewType.LISTA_STANOWISKA;
            case 4:
                return ViewType.LISTA_DZIALY;
            default:
                return ViewType.ZAKONCZ;
        }
    }

    private static ViewType showStanowiska(ViewCanvas canvas) {
        FrameView frame = new FrameView("Stanowiska");

        TableView tableView = new TableView(frame)
                .appendColumn("Id")
                .appendColumn("Nazwa")
                .appendColumn("Opis");
        tableView.setHeight(-1);

        Collection<Stanowisko> stanowiska = PracownikManager.getStanowisko();
        for (Stanowisko stanowisko : stanowiska) {
            tableView.addRow(
                    stanowisko.getId(),
                    stanowisko.getNazwa(),
                    stanowisko.getOpis()
            );
        }
        boolean disabled = stanowiska.isEmpty();
        createMenu(frame, "Dodaj", disabled ? null : "Usuń", "Pracownicy", "Działy", "Wyjście");

        frame.draw(canvas);
        CLI.println(canvas);
        List<Integer> disabledList = new ArrayList<>();
        if (disabled) {
            disabledList.add(2);
        }
        switch (selectedOption(5, disabledList)) {
            case 1:
                return ViewType.DODAJ_STANOWISKO;
            case 2:
                return ViewType.USUN_STANOWISKO;
            case 3:
                return ViewType.LISTA_PRACOWNICY;
            case 4:
                return ViewType.LISTA_DZIALY;
            default:
                return ViewType.ZAKONCZ;
        }
    }

    private static ViewType showDzialy(ViewCanvas canvas) {
        FrameView frame = new FrameView("Działy");

        TableView tableView = new TableView(frame)
                .appendColumn("Id")
                .appendColumn("Nazwa")
                .appendColumn("Opis");
        tableView.setHeight(-1);

        Collection<Dzial> dzialy = PracownikManager.getDzial();
        for (Dzial dzial : dzialy) {
            tableView.addRow(
                    dzial.getId(),
                    dzial.getNazwa(),
                    dzial.getOpis()
            );
        }
        boolean disabled = dzialy.isEmpty();
        createMenu(frame, "Dodaj", disabled ? null : "Usuń", "Pracownicy", "Stanowiska", "Wyjście");

        frame.draw(canvas);
        CLI.println(canvas);
        List<Integer> disabledList = new ArrayList<>();
        if (disabled) {
            disabledList.add(2);
        }
        switch (selectedOption(5, disabledList)) {
            case 1:
                return ViewType.DODAJ_DZIAL;
            case 2:
                return ViewType.USUN_DZIAL;
            case 3:
                return ViewType.LISTA_PRACOWNICY;
            case 4:
                return ViewType.LISTA_STANOWISKA;
            default:
                return ViewType.ZAKONCZ;
        }
    }

    private static void createMenu(FrameView frame, String... options) {
        ViewContainer container = new ViewContainer(frame, false);
        container.setHeight(1);
        for (int i = 0; i < options.length; i++) {
            String text = options[i] == null ? "" : (i + 1) + ": " + options[i];
            new LabelView(container, text).setHeight(1);
        }
    }

    private static int selectedOption(int last) {
        return selectedOption(last, Collections.EMPTY_LIST);
    }

    private static int selectedOption(int last, List<Integer> disabled) {
        while (true) {
            CLI.print("Podaj numer opcji [1-" + last + "]: ");
            try {
                int opcja = CLI.nextInt();

                if (opcja < 1 || opcja > last || disabled.contains(opcja)) {
                    CLI.println("Wybrano niepoprawny numer opcji");
                } else {
                    return opcja;
                }
            } catch (InputMismatchException e) {
                CLI.nextLine();
                CLI.println("Wybrano niepoprawny numer opcji");
            }
        }
    }

    public static void init(String[] args) {
        ViewCanvas canvas = new ViewCanvasImpl(100, 30, StandardCharsets.UTF_8);
        ViewType type = ViewType.LISTA_PRACOWNICY;
        long id;
        do {
            try {
                canvas.clear();
                switch (type) {
                    default:
                    case LISTA_PRACOWNICY:
                        type = showPracownicy(canvas);
                        break;
                    case LISTA_STANOWISKA:
                        type = showStanowiska(canvas);
                        break;
                    case LISTA_DZIALY:
                        type = showDzialy(canvas);
                        break;
                    case USUN_PRACOWNIKA:
                        type = ViewType.LISTA_PRACOWNICY;
                        CLI.print("Podaj id pracownika do usunięcia lub 0 aby anulować.\n\tId pracownika: ");
                        id = CLI.nextLong();
                        if (id > 0) {
                            if (PracownikManager.deletePracownik(id)) {
                                CLI.println("Pracownik został usunięty");
                            } else {
                                CLI.println("Nie udało się usunąć pracownika");
                            }
                        }
                        break;
                    case USUN_STANOWISKO:
                        type = ViewType.LISTA_STANOWISKA;
                        CLI.println("Do stanowiska nie mogą być przypisani pracownicy");
                        CLI.print("Podaj id stanowiska do usunięcia lub 0 aby anulować.\n\tId stanowisko: ");
                        id = CLI.nextLong();
                        if (id > 0) {
                            if (PracownikManager.deleteStanowisko(id)) {
                                CLI.println("Stanowisko zostało usunięty");
                            } else {
                                CLI.println("Nie udało się usunąć stanowiska");
                            }
                        }
                        break;
                    case USUN_DZIAL:
                        type = ViewType.LISTA_DZIALY;
                        CLI.println("Do działu nie mogą być przypisani pracownicy");
                        CLI.print("Podaj id działu do usunięcia lub 0 aby anulować.\n\tId działu: ");
                        id = CLI.nextLong();
                        if (id > 0) {
                            if (PracownikManager.deleteDzial(id)) {
                                CLI.println("Dział został usunięty");
                            } else {
                                CLI.println("Nie udało się usunąć działu");
                            }
                        }
                        break;
                    case DODAJ_PRACOWNIKA:
                        type = ViewType.LISTA_PRACOWNICY;
                        CLIFormValues<FormPracownik> formPracownik = CLI.printForm(FormPracownik.class);
                        if (formPracownik == null) {
                            break;
                        }
                        Stanowisko stanowisko = null;
                        String tmp = formPracownik.getValue(FormPracownik.STANOWISKO);
                        if (StringUtils.isNumeric(tmp)) {
                            stanowisko = PracownikManager.getStanowisko(Long.parseUnsignedLong(tmp));
                        }
                        if (stanowisko == null) {
                            stanowisko = PracownikManager.getStanowisko(tmp);
                        }
                        Dzial dzial = null;
                        tmp = formPracownik.getValue(FormPracownik.DZIAL);
                        if (StringUtils.isNumeric(tmp)) {
                            dzial = PracownikManager.getDzial(Long.parseUnsignedLong(tmp));
                        }
                        if (dzial == null) {
                            dzial = PracownikManager.getDzial(tmp);
                        }
                        PracownikManager.createPracownik(
                                formPracownik.getValue(FormPracownik.IMIE),
                                formPracownik.getValue(FormPracownik.NAZWISKO),
                                Long.parseUnsignedLong(formPracownik.getValue(FormPracownik.PESEL)))
                                .telefon(Long.parseUnsignedLong(formPracownik.getValue(FormPracownik.TELEFON)))
                                .adres(formPracownik.getValue(FormPracownik.ADRES))
                                .stanowisko(stanowisko)
                                .dzial(dzial)
                                .build();
                        break;
                    case DODAJ_STANOWISKO:
                        type = ViewType.LISTA_STANOWISKA;
                        CLIFormValues<FormStanowisko> formStanowisko = CLI.printForm(FormStanowisko.class);
                        if (formStanowisko == null) {
                            break;
                        }
                        PracownikManager.createStanowisko(
                                formStanowisko.getValue(FormStanowisko.NAZWA),
                                formStanowisko.getValue(FormStanowisko.OPIS));
                        break;
                    case DODAJ_DZIAL:
                        type = ViewType.LISTA_DZIALY;
                        CLIFormValues<FormDzial> formDzial = CLI.printForm(FormDzial.class);
                        if (formDzial == null) {
                            break;
                        }
                        PracownikManager.createDzial(
                                formDzial.getValue(FormDzial.NAZWA),
                                formDzial.getValue(FormDzial.OPIS));
                        break;
                }
            } catch (InputMismatchException e) {
                CLI.println("Niepoprawna wartość");
            }
        } while (type != ViewType.ZAKONCZ);
        CLI.println("Program zakończył działanie...");
    }
}
