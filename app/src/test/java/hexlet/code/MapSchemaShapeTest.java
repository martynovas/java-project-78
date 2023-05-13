package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaShapeTest {
    private MapSchema schema;

    @BeforeEach
    void init() {
        Validator validator = new Validator();
        schema = validator.map();

        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        schema.shape(schemas);
    }

    @ParameterizedTest
    @MethodSource("testDataSource")
    void test(String name, Integer age, Boolean result) {
        var map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("age", age);
        assertThat(
                schema.isValid(map)
        ).isEqualTo(result);
    }

    private static Stream<Arguments> testDataSource() {
        return Stream.of(
                Arguments.of("Kolya", 100, true),
                Arguments.of("Maya", null, true),
                Arguments.of("", null, false),
                Arguments.of("Valya", -5, false)
        );
    }
}
