package at.fhv.vp.memoization.main;

/**
 * This class was implemented to pass a year, month and day to the function "addToTime" as one parameter.
 * Additional parameters could be added.
 *
 * @author Valérie Peter
 * @date 7/23/2019
 */
public class Date {

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }
}
