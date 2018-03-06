package rpn.implementations;


import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rpn.RpnEvaluator;
import rpn.RpnTestable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Test RPN with stack")
public class RpnByStackTest {
    private final RpnByStack rpn = new RpnByStack();

    @Test
    void should_fail_with_null_argument() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> this.rpn.evaluate(null));
    }

    @Test
    void should_fail_with_empty_expresion() {
        assertThatThrownBy(() -> this.rpn.evaluate("")).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(delimiter=' ', value = {"2 + 2 4", "4 - 2 2", "2 * 2 4", "4 / 2 2", "2 ^ 2 4"})
    void check_operations_basic(final double a, @NotNull final Character op, final double b, final double result,
                                final TestInfo info, final TestReporter reporter) {
        reporter.publishEntry(info.getDisplayName(), op.toString());
        assertThat(RpnByStack.getOperands()).isNotNull()/*.isNotEmpty()*/.containsKeys(op);
        assertThat(RpnByStack.getOperands().get(op).apply(a, b)).isEqualTo(result);
    }

    @Nested
    @DisplayName("Common part")
    class CommonTests implements RpnTestable {
        @Override
        public RpnEvaluator getInstance() {
            return rpn;
        }
    }
}
