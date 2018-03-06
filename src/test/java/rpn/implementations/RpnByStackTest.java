package rpn.implementations;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import rpn.RpnEvaluator;
import rpn.RpnTestable;

@DisplayName("Test RPN with stack")
public class RpnByStackTest {
    private final RpnEvaluator rpn = new RpnByStack();

    @Nested
    @DisplayName("Common part")
    class CommonTests implements RpnTestable {
        @Override
        public RpnEvaluator getInstance() {
            return rpn;
        }
    }
}
