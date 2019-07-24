package at.fhv.vp.memoization.main;

/**
 * This class contains a "Fibonnaci" method, which could be used to test the Java memoization implementation.
 *
 * @author Valérie Peter
 * @date 7/23/2019
 */
public class FibonacciMemoization {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
