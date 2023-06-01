package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        clazz = Integer.class;
    }
    public NumberSchema required() {
        isRequeired = true;
        return this;
    }

    public NumberSchema positive() {
        predicates.add(v -> ((int) v) > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        predicates.add(v ->  ((int) v) >= min && ((int) v) <= max);
        return this;
    }
}
