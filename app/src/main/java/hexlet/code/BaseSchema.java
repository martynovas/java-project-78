package hexlet.code;

import java.util.LinkedHashSet;
import java.util.Set;

public class BaseSchema {
    protected Set<Restrection> restrections = new LinkedHashSet<>();

    public static boolean nonNull(Object obj) {
        return obj != null;
    }

    public BaseSchema required() {
        restrections.add(BaseSchema::nonNull);
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
