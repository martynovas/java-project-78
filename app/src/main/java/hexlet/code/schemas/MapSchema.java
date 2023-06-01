package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        clazz = Map.class;
    }

    public MapSchema required() {
        isRequeired = true;
        return this;
    }

    public MapSchema sizeof(int value) {
        required();
        predicates.add(v -> ((Map) v).size() == value);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> value) {
        required();
        predicates.add(m -> {
            for (var e : value.entrySet()) {
                if (!e.getValue().isValid(((Map<?, ?>) m).get(e.getKey()))) {
                    return false;
                }
            }

            return true;
        });
        return this;
    }
}
