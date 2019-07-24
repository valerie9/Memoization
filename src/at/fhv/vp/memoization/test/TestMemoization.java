package at.fhv.vp.memoization.test;

import at.fhv.vp.memoization.main.Date;
import at.fhv.vp.memoization.main.Memoization;
import at.fhv.vp.memoization.main.TimeMemoization;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

/**
 * This class contains a test to test the memoization implementation with Java. Memoization is tested with the method "addToTime". Another possibility to test this
 * would be Fibonacci numbers.
 *
 * @author Valérie Peter
 * @date 7/23/2019
 */
public class TestMemoization {
    /*
    The implementation with Java Generics and functional programming was a bit complicated, because these are not really study topics at the FH Vorarlberg.
    The time has therefore become too short to implement a resolver. At the moment the input parameter is the key. It's also missing
    that if the resolver is null the first parameter is taken as key. The function "addToTime" was also simplified by using the input parameter "Date",
    which was implemented in a separate class.
    One way to implement a resolver in Java would be to create a function in the test file like this:
    Function<Date, String> myResolverFunction = (time) -> {
        return "hallo";
    };
    The memoization class would have three generic types and the resolver would be passed as an additional parameter into the "callMemoize" method.
    Then the key could be computed by resolving the resolver function.
     */

    /**
     * First a memoization object is created. Then the function is applied four times with the same parameters.
     * The results are saved and printed in the console. The duration time of the method is also calculated.
     * The first two results should be the same, after a timeout of five seconds the entry is deleted from the map. That's why
     * the last two results have different values.
     */
    @Test
    public void testTime() {
        Function<Date, Long> f = TimeMemoization::addToTime;
        Function<Date, Long> g = Memoization.createMemoize(f, 5000);

        //first time
        long startTime = System.currentTimeMillis();
        long result1 = g.apply(new Date(2019, 7, 24));
        long time1 = System.currentTimeMillis() - startTime;

        //second time
        startTime = System.currentTimeMillis();
        long result2 = g.apply(new Date(2019, 7, 24));
        long time2 = System.currentTimeMillis() - startTime;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //third time
        startTime = System.currentTimeMillis();
        long result3 = g.apply(new Date(2019, 7, 24));
        long time3 = System.currentTimeMillis() - startTime;

        //fourth time
        startTime = System.currentTimeMillis();
        long result4 = g.apply(new Date(2019, 7, 24));
        long time4 = System.currentTimeMillis() - startTime;

        System.out.println("First time: " + result1 + " time: " + time1 + "ms");
        System.out.println("Second time: " + result2 + " time: " + time2 + "ms");
        System.out.println("Third time: " + result3 + " time: " + time3 + "ms");
        System.out.println("Fourth time: " + result4 + " time: " + time4 + "ms");

        Assert.assertEquals(result1, result2);
        Assert.assertEquals(result3, result4);
        Assert.assertNotEquals(result1, result3);
    }
}


