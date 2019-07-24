package at.fhv.vp.memoization.main;

import org.apache.commons.collections4.map.PassiveExpiringMap;

import java.util.Map;
import java.util.function.Function;

/**
 * This class contains the memoization functionality.
 * The memoization object is created by using the factory-method.
 *
 * @author Valérie Peter
 * @date 7/23/2019
 */
public class Memoization<T, U> {
    private Map<T, U> cachedValues;

    /* Entries in the map have to be deleted after a specific timeout, then a new entry will be generated. Solving this problem with a normal concurrent hashmap
     * was complicated. That's why the PassiveExpiring Map from Apache is used. It can
     * can be found under: https://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/map/PassiveExpiringMap.html
     * The first try with the weak concurrent hash map wasn't successful. Another well-known possibility is the library Guava from Google Collections.
     * This solutions are described here: https://stackoverflow.com/questions/3802370/java-time-based-map-cache-with-expiring-keys
     * I downloaded the map from Apache. Another solution would be to generate a Maven project.
     */

    /**
     * This is the private constructor.
     *
     * @param timeout timeout for cached values in milliseconds
     */
    private Memoization(Integer timeout) {
        cachedValues = new PassiveExpiringMap<>(timeout);
    }

    /**
     * This function is used to create a new Memoization object and to call the memoize function.
     *
     * @param func    The result of this function will be memoized.
     * @param timeout timeout for cached values in milliseconds
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> Function<T, U> createMemoize(final Function<T, U> func, Integer timeout) {
        return new Memoization<T, U>(timeout).memoize(func);
    }

    /**
     * The method computeIfAbsent() checks if an entry with this key already exists in the map, otherwise a new entry is generated. Tbe method
     * also checks if a entry has timed out and has to be deleted.
     *
     * @param func The result of this function will be memoized.
     * @return
     */
    private Function<T, U> memoize(Function<T, U> func) {
        return input -> cachedValues.computeIfAbsent(input, func::apply);
    }
}

