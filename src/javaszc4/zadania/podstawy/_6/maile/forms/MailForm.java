package javaszc4.zadania.podstawy._6.maile.forms;

import javaszc4.zadania.podstawy._6.maile.cli.CLIFormInput;

import java.util.regex.Pattern;

public enum MailForm implements CLIFormInput {
    FROM("From") {
        @Override
        public boolean isValid(String value) {
            return super.isValid(value) &&
                    RFC_2822.matcher(value.trim()).matches();
        }
    },
    TO("To") {
        @Override
        public boolean isValid(String value) {
            return super.isValid(value) &&
                    RFC_2822.matcher(value.trim()).matches();
        }
    },
    SUBJECT("Subject"),
    BODY("Body");

    private static final Pattern RFC_2822 = Pattern.compile(
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
    );

    private final String label;

    MailForm(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public boolean isValid(String value) {
        return value != null && !value.isEmpty();
    }
}
