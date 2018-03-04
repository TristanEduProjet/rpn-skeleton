package rpn;

import org.jetbrains.annotations.NotNull;
import org.kohsuke.MetaInfServices;

@MetaInfServices
public class RpnImpl implements RpnEvaluator {
    /**
     * Evaluate and process en RPN expression
     *
     * @param expression the RPN expression
     * @return the result
     */
    @Override
    public long evaluate(@NotNull String expression) {
        return 0;
    }
}
