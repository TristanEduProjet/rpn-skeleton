package rpn;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(final String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        long result = evaluate(expression);
        System.out.println("> " + result);
    }

    static long evaluate(@NonNull @NotNull final String expression) {
        return 0;
    }
}
