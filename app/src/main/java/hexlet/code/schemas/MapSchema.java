package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema {
    private int size;

    private Map<String, BaseSchema> shape;

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
        restrections.add(v -> Objects.isNull(v) || ((Map) v).size() == value);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> value) {
        shape = value;

        restrections.add(m -> {
            if (Objects.nonNull(m)) {
                for (var e : ((Map<?, ?>) m).entrySet()) {
                    BaseSchema schema = shape.get(e.getKey());
                    if (Objects.nonNull(schema)) {
                        if (!schema.isValid(e.getValue())) {
                            return false;
                        }
                    }
                }
            }

            return true;
        });
        return this;
    }
}
