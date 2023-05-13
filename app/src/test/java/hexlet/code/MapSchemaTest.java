package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public final class MapSchemaTest {
    private MapSchema schema;

    private Map<String, String> testMap;

    @BeforeEach
    void init() {
        Validator validator = new Validator();
        schema = validator.map();

        testMap = new HashMap<>();
        testMap.put("key1", "value1");
        testMap.put("key2", "value2");
    }

    @Test
    void shouldPassWithValueNull() {
        assertThat(
                schema.isValid(null)
        ).isTrue();
    }

    @Test
    void shouldPassRequireValidation() {
        assertThat(
                schema.required().isValid(testMap)
        ).isTrue();
    }

    @ParameterizedTest
    @NullSource
    void shouldFailRequireValidationWithNullAndEmpty(Map value) {
        assertThat(
                schema.required().isValid(value)
        ).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {2})
    void shouldPassSizeOfValidation(int value) {
        assertThat(
                schema.sizeof(value).isValid(testMap)
        ).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 3})
    void shouldFailSizeOfValidation(int value) {
        assertThat(
                schema.sizeof(value).isValid(testMap)
        ).isFalse();
    }
}
