package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSchemaTest {
    private NumberSchema schema;

    @BeforeEach
    void init() {
        Validator validator = new Validator();
        schema = validator.number();
    }

    @Test
    void shouldPassWithValueNull() {
        assertThat(
                schema.isValid(null)
        ).isTrue();
    }

    @Test
    void shouldFailWithValueNotNumber() {
        assertThat(
                schema.isValid("Hello")
        ).isFalse();
        assertThat(
                schema.isValid(BigDecimal.ONE)
        ).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, 0, 10})
    void shouldPassRequireValidation(int value) {
        assertThat(
                schema.required().isValid(value)
        ).isTrue();
    }

    @ParameterizedTest
    @NullSource
    void shouldFailRequireValidationWithNullAndEmpty(Integer value) {
        assertThat(
                schema.required().isValid(value)
        ).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 1200})
    @NullSource
    void shouldPassPositiveValidation(Integer value) {
        assertThat(
                schema.positive().isValid(value)
        ).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -3, 0})
    void shouldFailPositiveValidation(int value) {
        assertThat(
                schema.positive().isValid(value)
        ).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, -1, 0, 1, 10})
    @NullSource
    void shouldPassRangeValidation(Integer value) {
        assertThat(
                schema.range(-3, 10).isValid(value)
        ).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -4, 11, 1000})
    void shouldFailRangeValidation(int value) {
        assertThat(
                schema.range(-3, 10).isValid(value)
        ).isFalse();
    }
}
