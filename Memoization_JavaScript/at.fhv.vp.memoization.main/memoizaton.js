/**
 * This file includes the javascript method memoize to memoize the results of a function.
 * @author Valérie Peter
 * @date 7/23/2019
 *
 * @param f   the function for which the return values should be cached
 * @param resolver if provided gets called for each function call with the exact same set of parameters as the
 *                 original function, the resolver function should provide the memoization key.
 * @param timeout  timeout for cached values in milliseconds
 */
function memoize(f, resolver, timeout) {

    let cache = {};
    let times = {};

    return function TimedMemoizedFunction() {
        var key;
        if (resolver === null) {
            key = arguments[0]; //default -> first argument provided to the memorized function is used as the map cache key
        } else {
            key = resolver.apply(resolver, arguments); //resolver function is computed
        }
        var now = new Date();
        if (typeof (cache[key]) === 'undefined' || typeof (times[key]) === 'undefined' || (now - times[key]) >= timeout) {
            cache[key] = f.apply(f, arguments);
            times[key] = now;
        }
        return cache[key];
    };
}

module.exports = {
    memoize
};