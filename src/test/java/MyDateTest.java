import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YunZhang on 8/2/17.
 */
public class MyDateTest {
    @Test
    public void isLeapYear() throws Exception {
        assertFalse("1700 is not a leap year",
                new MyDate(1700,1,1).isLeapYear());

        //2000 is a leap year
        assertTrue("2000 is a leap year",
                new MyDate(2000,2,2).isLeapYear());

        //1980 is a leap year
        assertTrue("1980 is a leap year",
                new MyDate(1980,2,3).isLeapYear());
        assertFalse("1970 is a not a leap year",
                new MyDate(1970,2,1).isLeapYear());

        assertFalse("1973 is a not a leap year",
                new MyDate(1973,2,1).isLeapYear());
    }

    @Test
    public void testTotalDaysThisYear(){

        final int DAYS_366 = 366;
        final int DAYS_365 = 365;
        assertEquals("1700 contains 365 days",DAYS_365,
                new MyDate(1700,1,1).totalDaysThisYear());

        assertEquals("2000 contains 366 days",DAYS_366,
                new MyDate(2000,1,1).totalDaysThisYear());

        assertEquals("1980 contains 366 days",DAYS_366,
                new MyDate(1980,1,1).totalDaysThisYear());

        assertEquals("1970 contains 365 days",DAYS_365,
                new MyDate(1970,1,1).totalDaysThisYear());

        assertEquals("1973 contains 365 days",DAYS_365,
                new MyDate(1973,1,1).totalDaysThisYear());
    }

    @Test
    public void testTotalDaysThisMonth(){
        assertEquals("Jan Contains 31 days",
                31,new MyDate(2000,1,10).totalDaysThisMonth());

        assertEquals("Feb-1980 Contains 29 days",
                29,new MyDate(1980,2,10).totalDaysThisMonth());

        assertEquals("Feb-1981 Contains 28 days",
                28,new MyDate(1981,2,10).totalDaysThisMonth());

        assertEquals("Nov-1981 Contains 30 days",
                30,new MyDate(1981,11,10).totalDaysThisMonth());

        assertEquals("Dec-1981 Contains 31 days",
                31,new MyDate(1981,12,10).totalDaysThisMonth());
    }

}