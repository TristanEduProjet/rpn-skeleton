package rpn;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("Test CLI RPN")
public class CLITest {
    private final RpnEvaluator rpn = new RpnImpl();

    @Nested
    @DisplayName("Common part")
    class CommonTests implements RpnTestable {
        @Override
        public RpnEvaluator getInstance() {
            return rpn;
        }
    }
}
