package at.fhv.vp.memoization.test;

import at.fhv.vp.memoization.main.FibonacciMemoization;
import at.fhv.vp.memoization.main.Memoization;
import at.fhv.vp.memoization.main.TimeMemoization;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

public class TestMemoization {


    @Test
    public void testString() {
        Function<Integer, Long> f = TimeMemoization::addToTime;
        Function<Integer, Long> g = Memoization.callMemoize(f, 5000);

        //first time
        long startTime = System.currentTimeMillis();
        long result1 = g.apply(40);
        long time1 = System.currentTimeMillis() - startTime;

        //second time
        startTime = System.currentTimeMillis();
        long result2 = g.apply(40);
        long time2 = System.currentTimeMillis() - startTime;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //third time
        startTime = System.currentTimeMillis();
        long result3 = g.apply(40);
        long time3 = System.currentTimeMillis() - startTime;

        //fourth time
        startTime = System.currentTimeMillis();
        long result4 = g.apply(40);
        long time4 = System.currentTimeMillis() - startTime;

        System.out.println("First time: " + result1 + " time: " + time1 + "ms");
        System.out.println("Second time: " + result2 + " time: " + time2 + "ms");
        System.out.println("Third time: " + result3 + " time: " + time3 + "ms");
        System.out.println("Fourth time: " + result4 + " time: " + time4 + "ms");

    }

    @Test
    public void testFibonacci_1() {
        Function<Integer, Integer> f = FibonacciMemoization::fibonacci;
        Function<Integer, Integer> g = Memoization.callMemoize(f, 5000);
        System.out.println(g.apply(22));
        Assert.assertEquals(g.apply(22), new Integer(17711));
    }

    @Test
    public void testFibonacci_2() {
        Function<Integer, Integer> f = FibonacciMemoization::fibonacci;
        Function<Integer, Integer> g = Memoization.callMemoize(f, 5000);
        System.out.println(g.apply(5));
        Assert.assertEquals(g.apply(5), new Integer(5));
    }
}


