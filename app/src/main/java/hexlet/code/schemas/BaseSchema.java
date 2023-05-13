package hexlet.code.schemas;

import hexlet.code.Restrection;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public abstract class BaseSchema {
    protected Set<Restrection> restrections = new LinkedHashSet<>();

    /**
     * Method add to schema required validation.
     * @return this object
     */
    protected BaseSchema required() {
        restrections.add(Objects::nonNull);
        return this;
    }

    public final boolean isValid(Object value) {
        for (var r : restrections) {
            if (!r.check(value)) {
                return false;
            }
        }

        return true;
    }
}
