package javaszc4.zadania.podstawy._6.maile;

import javaszc4.zadania.podstawy._6.maile.cli.CLIFormValues;
import javaszc4.zadania.podstawy._6.maile.cli.CommandLineInterface;
import javaszc4.zadania.podstawy._6.maile.forms.MailForm;
import javaszc4.zadania.podstawy._6.maile.menus.MainMenu;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final CommandLineInterface CLI = new CommandLineInterface();

    private static Message napiszMaila() {
        CLIFormValues<MailForm> valuse = CLI.printForm(MailForm.class);
        if (valuse == null) {
            return null;
        }
        TextMessage message = new TextMessage();
        message.setFrom(valuse.getValue(MailForm.FROM));
        message.setTo(valuse.getValue(MailForm.TO));
        message.setSubject(valuse.getValue(MailForm.SUBJECT));
        message.setBody(valuse.getValue(MailForm.BODY));
        return message;
    }

    public static void main(String[] args) {
        Queue<Message> messages = new LinkedList<>();
        MessageSender sender = new MessageSender();
        Message message;
        while (true) {
            MainMenu mainMenu = CLI.printMenu(MainMenu.class);
            switch (mainMenu) {
                case NAPISZ:
                    message = napiszMaila();
                    if (message != null) {
                        messages.add(message);
                    }
                    break;
                case WYSLIJ:
                    if (messages.isEmpty()) {
                        System.out.println("Brak wiadomości do wysłania");
                    } else while (!messages.isEmpty()) {
                        Message m = messages.poll();
                        System.out.println("Wysyłanie wiadomości: " + m);
                        if (sender.sendMessage(m)) {
                            System.out.println("Wiadomośc została wysłana");
                        } else {
                            System.out.println("Wiadomość nie została wysłana");
                            if (messages.add(m)) {
                                System.out.println("Wiadomość wróciła do listy wiadomości do wysłania");
                            }
                        }
                    }
                    break;
                case WYSWIETL:
                    System.out.println("Wiadomości czekające w kolejce do wysłania:");
                    for (Message m : messages) {
                        System.out.println("\t" + m);
                    }
                    break;
                case WYJDZ:
                    System.out.println("Koniec programu");
                    return;
            }
        }
    }
}
