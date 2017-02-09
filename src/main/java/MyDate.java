/**
 * Date encapsulating day, month and year
 * Created by Yun Zhang on 8/2/17.
 */
public class MyDate implements Comparable<MyDate>{

    public static final int MIN_YEAR = 1900;
    //min date based on assumption that date caculation ranges from 1900 to 2010
    public final static MyDate MIN_DATE = new MyDate(MIN_YEAR,1,1);

    //max date
    public static final int MAX_YEAR = 2010;
    public final static MyDate MAX_DATE = new MyDate(MAX_YEAR,12,31);

    /*
     * Year component of a date, range from 1900 and 2010
     */
    private int year;

    /**
     * Month component of a date
     */
    private int month;

    /**
     * Day component of a date
     */
    private int day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public MyDate(int year, int month, int day) {
        //year must be between 1900 and 2010
        if (year < MIN_YEAR || year > MAX_YEAR){
            throw new IllegalArgumentException(String.format("year must range from %d to %d",
                    MIN_YEAR,MAX_YEAR));
        }
        if (month < 1 || month > 12){
            throw new IllegalArgumentException("month must range from 1 to 12");
        }
        this.year = year;
        this.month = month;
        this.day = day;
        if (day < 1 || day > totalDaysThisMonth()){
            throw new IllegalArgumentException(String.format("day must range from 1 to %d for %d-%d",
                    totalDaysThisMonth(),month,year));
        }
    }

    public boolean isLeapYear(){
        return isLeapYear(year);
    }

    private boolean isLeapYear(int aYear) {
        if (aYear % 100 == 0) {
            return aYear % 400 == 0;
        } else {
            return aYear % 4 == 0;
        }
    }

    public int totalDaysThisYear(){
        return isLeapYear() ? 366 : 365;
    }

    private int totalDaysThisYear(int aYear) {
        return isLeapYear(aYear) ? 366 : 365;
    }

    /**
     * returns how many days for <code>month</>
     * @return
     */
    public int totalDaysThisMonth() {
        return totalDaysThisMonth(month);
    }

    private int totalDaysThisMonth(int aMonth) {
        switch (aMonth){
            //Jan,March, May, July, August, October or December contains 31 days
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2: //February contains 29 days if it is a leap year
                return isLeapYear() ? 29 : 28;
            default: //the rest months contain 30 days
                return 30;
        }
    }

    public int elapsedDays() {
        int days = 0;
        for (int i = MIN_DATE.year; i < this.year ; i++) {
            days += totalDaysThisYear(i);
        }
        for (int i = MIN_DATE.month; i < this.month; i++) {
            days += totalDaysThisMonth(i);
        }
        days += this.day - MIN_DATE.day;
        return days;
    }

    public int compareTo(MyDate o) {
        Integer self = this.elapsedDays();
        Integer other = o.elapsedDays();
        return self.compareTo(other);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(day < 10 ? "0" + String.valueOf(day): String.valueOf(day))
                .append(" ").append(month < 10 ? "0" + String.valueOf(month): String.valueOf(month))
                .append(" " + String.valueOf(year));
        return sb.toString();
    }
}
