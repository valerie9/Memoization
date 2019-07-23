package at.fhv.vp.memoization.main;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;


public class Memoization<T, U> {
    private Map<T, U> cachedValues = new ConcurrentHashMap<>();

    private Memoization() {
    }

    public static <T, U> Function<T, U> callMemoize(final Function<T, U> func) {
        return new Memoization<T, U>().memoize(func);
    }

    private Function<T, U> memoize(Function<T, U> func) {
        return input -> cachedValues.computeIfAbsent(input, func::apply);
    }
}
