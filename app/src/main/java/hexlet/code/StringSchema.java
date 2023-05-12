package hexlet.code;

import java.util.Objects;

public class StringSchema {
    private boolean isRequired = false;
    private int minLength = -1;

    private String contains;


    public StringSchema required() {
        isRequired = true;
        return this;
    }

    public StringSchema minLength(int value) {
        minLength = value;
        return this;
    }

    public StringSchema contains(String value) {
        contains = value;
        return this;
    }

    public boolean isValid(Object value) {
        if (!isRequired && Objects.isNull(value)) {
            return true;
        }

        if (!(value instanceof String)) {
            return false;
        }

        String str = (String) value;

        if (isRequired && str.isBlank()) {
            return false;
        }

        if (str.length() < minLength) {
            return false;
        }

        if (Objects.nonNull(contains)) {
            if (!str.contains(contains)) {
                return false;
            }
        }

        return true;
    }


}
