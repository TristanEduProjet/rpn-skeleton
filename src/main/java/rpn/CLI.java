package rpn;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static void main(final String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        System.out.println("> " + getImplementations().get(RpnImpl.class.getSimpleName()).evaluate(expression));
    }

    private static Map<String, RpnEvaluator> getImplementations() {
        final Map<String, RpnEvaluator> impls = new HashMap<>();
        ServiceLoader.load(RpnEvaluator.class).forEach(rpn -> impls.put(rpn.getClass().getSimpleName(), rpn));
        return impls;
    }
}
