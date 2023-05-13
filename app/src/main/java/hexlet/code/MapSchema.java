package hexlet.code;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema {
    private int size;

    MapSchema() {
        restrections.add(v -> Objects.isNull(v) || v instanceof Map<?, ?>);
    }

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int value) {
        size = value;
        restrections.add(v -> ((Map) v).size() == value);
        return this;
    }
}
