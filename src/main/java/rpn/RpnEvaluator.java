package rpn;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public interface RpnEvaluator {
    /**
     * Evaluate and process en RPN expression
     * @param expression the RPN expression
     * @return the result
     */
    long evaluate(@NonNull @NotNull final String expression);
}
