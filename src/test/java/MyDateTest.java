import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YunZhang on 8/2/17.
 */
public class MyDateTest {
    @Test
    public void isLeapYear() throws Exception {
        assertFalse("1900 is not a leap year",
                new MyDate(1900,1,1).isLeapYear());

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
        assertEquals("1900 contains 365 days",DAYS_365,
                new MyDate(1900,1,1).totalDaysThisYear());

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

    @Test
    public void testElapsedDays(){
        MyDate myDate19000101 = new MyDate(1900,1,1);
        assertEquals("elapsed days for 01-01-1900 is 0 days",0,myDate19000101.elapsedDays());

        MyDate myDate19000120 = new MyDate(1900,1,20);
        assertEquals("elapsed days for 20-01-1900 is 19 days",19,myDate19000120.elapsedDays());

        MyDate myDate19000220 = new MyDate(1900,2,20);
        assertEquals("elapsed days for 20-02-1900 is 50 days",50,myDate19000220.elapsedDays());

        MyDate myDate19010220 = new MyDate(1901,2,20);
        assertEquals("elapsed days for 20-02-1901 is 415 days",415,myDate19010220.elapsedDays());

        MyDate myDate19020220 = new MyDate(1902,2,20);
        assertEquals("elapsed days for 20-02-1902 is 780 days",780,myDate19020220.elapsedDays());
    }

    @Test
    public void TestCompareTo(){
        assertEquals("equal",0,
                new MyDate(2000,1,1).compareTo(new MyDate(2000,1,1)));

        assertTrue("1-1-2000 is less than 2-1-2000",
                new MyDate(2000,1,1).compareTo(new MyDate(2000,2,1)) < 0);

        assertTrue("1-2-2000 is greater than 2-1-2000", new MyDate(2000,2,1).compareTo(new MyDate(2000,1,2)) > 0);
    }

    @Test
    public void TestToString(){
        assertEquals("1-2-1999 should be converted to 01 02 1999",
                "01 02 1999",new MyDate(1999,02,01).toString());

        assertEquals("10-12-1999 should be converted to 10 12 1999",
                "10 12 1999",new MyDate(1999,12,10).toString());
    }

}