package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        predicates.add(v -> Objects.isNull(v) || v instanceof Integer);
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        predicates.add(v -> Objects.isNull(v) || ((int) v) > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        predicates.add(v -> Objects.isNull(v) || ((int) v) >= min && ((int) v) <= max);
        return this;
    }
}
