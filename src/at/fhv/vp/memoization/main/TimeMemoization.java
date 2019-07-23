package at.fhv.vp.memoization.main;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimeMemoization {

    public static Long addToTime(Integer seconds) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + seconds;
    }
}
