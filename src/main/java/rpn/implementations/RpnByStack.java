package rpn.implementations;

import lombok.NonNull;
import org.apache.commons.lang3.math.NumberUtils;
import org.jetbrains.annotations.NotNull;
import org.kohsuke.MetaInfServices;
import rpn.RpnEvaluator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * Base/Common solution with a {@link java.util.Stack Stack}
 */
@MetaInfServices
public class RpnByStack implements RpnEvaluator {
    private final static Map<Character, BiFunction<Double, Double, Double>> operands = new HashMap<>();
    static {
        operands.put('+', (a, b) -> a+b);
        operands.put('-', (a, b) -> a-b);
        operands.put('*', (a, b) -> a*b);
        operands.put('/', (a, b) -> a/b);
        operands.put('^', Math::pow);
    }

    /**
     * Evaluate and process en RPN expression
     *
     * @param expression the RPN expression
     * @return the result
     * @throws IllegalStateException if the expression give too numbers without operate them
     */
    @Override
    public long evaluate(@NotNull final String expression) {
        final Stack<Double> stack = new Stack<>();
        for(@NotNull @NonNull final String tk : expression.split(" "))
            if(/*NumberUtils.isCreatable(tk) ||*/ NumberUtils.isParsable(tk))
                stack.push(Double.valueOf(tk));
            else
                stack.push(operands.get(tk.charAt(0)).apply(stack.pop(), stack.pop()));
        if(stack.size() > 1)
            throw new IllegalStateException("There are too numbers in stack");
        return (long)((double)stack.pop());
    }
}
