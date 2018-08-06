package javaszc4.zadania.podstawy._6.maile;

public abstract class Message {

    private String from;
    private String to;
    private String subject;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Wiadomość: " +
                "Od: '" + from + '\'' +
                ", Do: '" + to + '\'' +
                ", Temat: '" + subject + '\'';
    }
}
