package hexlet.code.schemas;

import hexlet.code.Restrection;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class BaseSchema {
    protected Set<Restrection> restrections = new LinkedHashSet<>();

    public BaseSchema required() {
        restrections.add(Objects::nonNull);
        return this;
    }

    public boolean isValid(Object value) {
        for (var r : restrections) {
            if (!r.check(value)) {
                return false;
            }
        }

        return true;
    }
}
