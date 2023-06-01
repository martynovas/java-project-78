package hexlet.code.schemas;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Set<Predicate> predicates = new LinkedHashSet<>();
    protected boolean isRequeired;

    protected Class clazz;

    public final boolean isValid(Object value) {
        if (value == null || !clazz.isInstance(value)) {
            return !isRequeired;
        } else {
            for (var r : predicates) {
                if (!r.test(value)) {
                    return false;
                }
            }
            return true;
        }
    }
}
