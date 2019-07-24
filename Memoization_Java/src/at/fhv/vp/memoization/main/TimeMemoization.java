package at.fhv.vp.memoization.main;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * This class contains the "addToTime" method, which is used to test the Java memoization implementation.
 *
 * @author Valérie Peter
 * @date 7/23/2019
 */
public class TimeMemoization {

    public static Long addToTime(Date date) {
        return LocalDateTime.now().plusYears(date.getYear()).plusMonths(date.getMonth()).plusDays(date.getDay()).toEpochSecond(ZoneOffset.UTC);
    }
}
