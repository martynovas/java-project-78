package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        clazz = String.class;
    }

    public StringSchema required() {
        isRequeired = true;
        predicates.add(v -> !((String) v).isEmpty() && !((String) v).isBlank());
        return this;
    }

    public StringSchema minLength(int value) {
        predicates.add(v -> ((String) v).length() >= value);
        return this;
    }

    public StringSchema contains(String value) {
        predicates.add(v -> ((String) v).contains(value));
        return this;
    }

}
