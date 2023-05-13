package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public final class StringSchemaTest {
    private StringSchema schema;

    @BeforeEach
    void init() {
        Validator validator = new Validator();
        schema = validator.string();
    }

    @Test
    void shouldPassWithValueNull() {
        assertThat(
                schema.isValid(null)
        ).isTrue();
    }

    @Test
    void shouldFailWithValueNotString() {
        assertThat(
                schema.isValid(5)
        ).isFalse();
        assertThat(
                schema.isValid(BigDecimal.ONE)
        ).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"H", "Hello", "Hello world!"})
    void shouldPassRequireValidation(String value) {
        assertThat(
                schema.required().isValid(value)
        ).isTrue();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldFailRequireValidationWithNullAndEmpty(String value) {
        assertThat(
                schema.required().isValid(value)
        ).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 3, 12})
    void shouldPassMinLengthValidation(int value) {
        assertThat(
                schema.minLength(value).isValid("Hello world!")
        ).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {13, 1000})
    void shouldFailMinLengthValidation(int value) {
        assertThat(
                schema.minLength(value).isValid("Hello world!")
        ).isFalse();
    }

    @Test
    void shouldPassZeroMinLengthValidationWithEmptyString() {
        assertThat(
                schema.minLength(0).isValid("")
        ).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "H", "Hello", "Hello world!"})
    void shouldPassContainValidation(String value) {
        assertThat(
                schema.contains(value).isValid("Hello world!")
        ).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {",", "Help", "hello"})
    void shouldFailContainValidation(String value) {
        assertThat(
                schema.contains(value).isValid("Hello world!")
        ).isFalse();
    }
}
