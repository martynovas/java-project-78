package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        clazz = Map.class;
    }

    public MapSchema required() {
        requeired = true;
        return this;
    }

    public MapSchema sizeof(int value) {
        predicates.add(v -> ((Map) v).size() == value);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> value) {
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
