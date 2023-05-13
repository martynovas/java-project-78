package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {
    private int minValue;
    private int maxValue;

    NumberSchema() {
        restrections.add(v -> Objects.isNull(v) || v instanceof Integer);
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        restrections.add(v -> Objects.isNull(v) || ((int) v) > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        minValue = min;
        maxValue = max;
        restrections.add(v -> Objects.isNull(v) ||  ((int) v) >= minValue && ((int) v) <= maxValue);
        return this;
    }
}
