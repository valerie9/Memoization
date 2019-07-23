package at.fhv.vp.memoization.main;

import org.apache.commons.collections4.map.PassiveExpiringMap;

import java.util.Map;
import java.util.function.Function;


public class Memoization<T, U> {
    private Map<T, U> cachedValues;

    private Memoization(Integer timeout) {
        cachedValues = new PassiveExpiringMap<>(timeout);
    }

    public static <T, U> Function<T, U> callMemoize(final Function<T, U> func, Integer timeout) {
        return new Memoization<T, U>(timeout).memoize(func);
    }

    private Function<T, U> memoize(Function<T, U> func) {
        return input -> cachedValues.computeIfAbsent(input, func::apply);
    }
}
