package hexlet.code.schemas;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Set<Predicate> predicates = new LinkedHashSet<>();

    /**
     * Method add to schema required validation.
     *
     * @return this object
     */
    protected BaseSchema required() {
        predicates.add(Objects::nonNull);
        return this;
    }

    public final boolean isValid(Object value) {
        for (var r : predicates) {
            if (!r.test(value)) {
                return false;
            }
        }

        return true;
    }
}
