package hexlet.code;

import java.util.Objects;

public class StringSchema extends BaseSchema {
    private int minLength;
    private String contains;

    StringSchema() {
        restrections.add(v -> Objects.isNull(v) || v instanceof String);
    }

    @Override
    public StringSchema required() {
        super.required();
        restrections.add(v -> (!(((String) v).isEmpty() && ((String) v).isBlank())));
        return this;
    }

    public StringSchema minLength(int value) {
        minLength = value;
        restrections.add(v -> Objects.isNull(v) || ((String) v).length() >= minLength);
        return this;
    }

    public StringSchema contains(String value) {
        contains = value;
        restrections.add(v -> Objects.isNull(v) || ((String) v).contains(contains));
        return this;
    }

}
