/**
 * Date encapsulating day, month and year
 * Created by Yun Zhang on 8/2/17.
 */
public class MyDate {

    //min date based on assumption that date caculation ranges from 1900 to 2010
    public final MyDate MIN_DATE = new MyDate(1900,1,1);

    //max date
    public final MyDate MAX_DATE = new MyDate(2010,12,31);

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

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapYear(){
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }

    public int totalDaysThisYear(){
        return isLeapYear() ? 366 : 365;
    }

    /**
     * returns how many days for <code>month</>
     * @return
     */
    public int totalDaysThisMonth() {
        switch (month){
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
}
