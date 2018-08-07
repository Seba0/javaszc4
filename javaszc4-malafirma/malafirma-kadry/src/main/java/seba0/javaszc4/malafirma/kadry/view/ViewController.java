package seba0.javaszc4.malafirma.kadry.view;


import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Scanner;
import seba0.javaszc4.malafirma.kadry.view.form.FormDzial;
import seba0.javaszc4.malafirma.kadry.view.form.FormPracownik;
import seba0.javaszc4.malafirma.kadry.view.form.FormStanowisko;
import seba0.javaszc4.malafirma.cli.SimpleForm;
import seba0.javaszc4.malafirma.cui.canvas.ViewCanvas;
import seba0.javaszc4.malafirma.cui.canvas.ViewCanvasImpl;
import seba0.javaszc4.malafirma.cui.components.FrameView;
import seba0.javaszc4.malafirma.cui.components.LabelView;
import seba0.javaszc4.malafirma.cui.components.TableView;
import seba0.javaszc4.malafirma.cui.components.ViewContainer;
import seba0.javaszc4.malafirma.kadry.pracownicy.Dzial;
import seba0.javaszc4.malafirma.kadry.pracownicy.Pracownik;
import seba0.javaszc4.malafirma.kadry.pracownicy.PracownikManager;
import seba0.javaszc4.malafirma.kadry.pracownicy.Stanowisko;
import seba0.javaszc4.malafirma.utils.StringUtils;

public final class ViewController {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final SimpleForm FORM = new SimpleForm();

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

        createMenu(frame, "Dodaj", "Usuń", "Stanowiska", "Działy", "Wyjście");

        frame.draw(canvas);
        System.out.println(canvas);
        switch (selectedOption(5)) {
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

        createMenu(frame, "Dodaj", "Usuń", "Pracownicy", "Działy", "Wyjście");

        frame.draw(canvas);
        System.out.println(canvas);
        switch (selectedOption(5)) {
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

        createMenu(frame, "Dodaj", "Usuń", "Pracownicy", "Stanowiska", "Wyjście");

        frame.draw(canvas);
        System.out.println(canvas);
        switch (selectedOption(5)) {
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
            new LabelView(container, (i + 1) + ": " + options[i]).setHeight(1);
        }
    }


    private static int selectedOption(int last) {
        while (true) {
            System.out.print("Podaj numer opcji [1-" + last + "]: ");
            int opcja = SCANNER.nextInt();
            if (opcja < 1 || opcja > last) {
                System.out.println("Wybrano niepoprawny numer opcji");
            } else {
                return opcja;
            }
        }
    }

    public static void init(String[] args) {
        ViewCanvas canvas = new ViewCanvasImpl(100, 30, StandardCharsets.UTF_8);
        ViewType type = ViewType.LISTA_PRACOWNICY;
        long id;
        String[] fields;
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
                        System.out.print("Podaj id pracownika do usunięcia lub 0 aby anulować.\n\tId pracownika: ");
                        id = SCANNER.nextLong();
                        if (id > 0) {
                            if (PracownikManager.deletePracownik(id)) {
                                System.out.println("Pracownik został usunięty");
                            } else {
                                System.out.println("Nie udało się usunąć pracownika");
                            }
                        }
                        break;
                    case USUN_STANOWISKO:
                        type = ViewType.LISTA_STANOWISKA;
                        System.out.println("Do stanowiska nie mogą być przypisani pracownicy");
                        System.out.print("Podaj id stanowiska do usunięcia lub 0 aby anulować.\n\tId stanowisko: ");
                        id = SCANNER.nextLong();
                        if (id > 0) {
                            if (PracownikManager.deleteStanowisko(id)) {
                                System.out.println("Stanowisko zostało usunięty");
                            } else {
                                System.out.println("Nie udało się usunąć stanowiska");
                            }
                        }
                        break;
                    case USUN_DZIAL:
                        type = ViewType.LISTA_DZIALY;
                        System.out.println("Do działu nie mogą być przypisani pracownicy");
                        System.out.print("Podaj id działu do usunięcia lub 0 aby anulować.\n\tId stanowisko: ");
                        id = SCANNER.nextLong();
                        if (id > 0) {
                            if (PracownikManager.deleteDzial(id)) {
                                System.out.println("Dział został usunięty");
                            } else {
                                System.out.println("Nie udało się usunąć działu");
                            }
                        }
                        break;
                    case DODAJ_PRACOWNIKA:
                        type = ViewType.LISTA_PRACOWNICY;
                        fields = FORM.printForm(FormPracownik.values());
                        if (fields == null) {
                            break;
                        }
                        Stanowisko stanowisko = null;
                        String tmp = fields[FormPracownik.STANOWISKO.ordinal()];
                        if (StringUtils.isNumeric(tmp)) {
                            stanowisko = PracownikManager.getStanowisko(Long.parseUnsignedLong(tmp));
                        }
                        if (stanowisko == null) {
                            stanowisko = PracownikManager.getStanowisko(tmp);
                        }
                        Dzial dzial = null;
                        tmp = fields[FormPracownik.DZIAL.ordinal()];
                        if (StringUtils.isNumeric(tmp)) {
                            dzial = PracownikManager.getDzial(Long.parseUnsignedLong(tmp));
                        }
                        if (dzial == null) {
                            dzial = PracownikManager.getDzial(tmp);
                        }
                        PracownikManager.createPracownik(
                                fields[FormPracownik.IMIE.ordinal()],
                                fields[FormPracownik.NAZWISKO.ordinal()],
                                Long.parseUnsignedLong(fields[FormPracownik.PESEL.ordinal()]))
                                .telefon(Long.parseUnsignedLong(fields[FormPracownik.TELEFON.ordinal()]))
                                .adres(fields[FormPracownik.ADRES.ordinal()])
                                .stanowisko(stanowisko)
                                .dzial(dzial)
                                .build();
                        break;
                    case DODAJ_STANOWISKO:
                        type = ViewType.LISTA_STANOWISKA;
                        fields = FORM.printForm(FormStanowisko.values());
                        if (fields == null) {
                            break;
                        }
                        PracownikManager.createStanowisko(
                                fields[FormStanowisko.NAZWA.ordinal()],
                                fields[FormStanowisko.OPIS.ordinal()]
                        );
                        break;
                    case DODAJ_DZIAL:
                        type = ViewType.LISTA_DZIALY;
                        fields = FORM.printForm(FormDzial.values());
                        if (fields == null) {
                            break;
                        }
                        PracownikManager.createDzial(
                                fields[FormDzial.NAZWA.ordinal()],
                                fields[FormDzial.OPIS.ordinal()]
                        );
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (type != ViewType.ZAKONCZ);
        System.out.println("Program zakończył działanie...");
    }
}
