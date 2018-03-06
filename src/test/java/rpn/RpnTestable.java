package rpn;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

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

    @Test
    @DisplayName("Simple addition")
    default void should_evaluate_simple_addition() {
        assertThat(this.getInstance().evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    @DisplayName("Two additions")
    default void should_evaluate_more_complex_addition() {
        assertThat(this.getInstance().evaluate("2 3 5 + +")).isEqualTo(10);
    }
}
