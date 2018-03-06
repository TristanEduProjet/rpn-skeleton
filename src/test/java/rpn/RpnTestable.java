package rpn;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Common tests for a {@link RpnEvaluator Rpn implementation}
 *
 * {@link java.util.ServiceLoader} was not used for tests in case another implementation is present in the classpath (like ine dependencies).
 * It permit also to do particular tests for certain implementations.
 */
@TestInstance(Lifecycle.PER_CLASS)
public interface RpnTestable {
    RpnEvaluator getInstance();

    @BeforeAll
    default void beforeAllTests() {
        assertThat(this.getInstance()).isNotNull();
    }

    @Test
    @DisplayName("single number (single digit)")
    default void should_evaluate_single_digit_constant() {
        assertThat(this.getInstance().evaluate("5")).isEqualTo(5);
    }

    @Test
    @DisplayName("single number (multiple digits)")
    default void should_evaluate_multiple_digits_constant() {
        assertThat(this.getInstance().evaluate("17")).isEqualTo(17);
    }

    @Test
    @DisplayName("single negative number (single digit)")
    default void should_evaluate_negative_single_digit_constant() {
        assertThat(this.getInstance().evaluate("-5")).isEqualTo(-5);
    }

    @Test
    @DisplayName("single negative number (multiple digits)")
    default void should_evaluate_negative_multiple_digits_constant() {
        assertThat(this.getInstance().evaluate("-17")).isEqualTo(-17);
    }

    @ParameterizedTest
    @DisplayName("Simple expressions")
    @CsvSource({"17 5 +, 22, Addition", "3 4 -, -1, Subtraction", "-2 -2 *, 4, Multiplication", "20 5 /, 4, Division"})
    default void should_evaluate_simple_operation(@NotNull final String expr, final double result,
                                                  @NonNull final String name, @NonNull final TestInfo info, @NonNull final TestReporter reporter) {
        reporter.publishEntry(info.getDisplayName(), name);
        assertThat(this.getInstance().evaluate(expr)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{arguments}")
    @DisplayName("Complexes expressions")
    @CsvSource(delimiter='=', value = {"2 3 5 + + =10", "5 2 3 + - =0", "3 4 - 5 + =4", "4 2 + 3 - =3", "3 5 8 * 7 + * =141"})
    default void should_evaluate_more_complex_operation(@NotNull final String expr, final double result) {
        assertThat(this.getInstance().evaluate(expr)).isEqualTo(result);
    }
}
