package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        predicates.add(v -> Objects.isNull(v) || v instanceof String);
    }

    @Override
    public StringSchema required() {
        super.required();
        predicates.add(v -> (!(((String) v).isEmpty() && ((String) v).isBlank())));
        return this;
    }

    public StringSchema minLength(int value) {
        predicates.add(v -> Objects.isNull(v) || ((String) v).length() >= value);
        return this;
    }

    public StringSchema contains(String value) {
        predicates.add(v -> Objects.isNull(v) || ((String) v).contains(value));
        return this;
    }

}
