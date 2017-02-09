import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by YunZhang on 9/2/17.
 */
public class DatePairParerImplTest {
    @Test(expected = NullPointerException.class)
    public void testParseDatePairWithNull() throws Exception {
        new DatePairParerImpl().parseDatePair(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseDatePairIllegal1(){
        DatePairParer datePairParer = new DatePairParerImpl();
        datePairParer.parseDatePair("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseDatePairIllegal2(){
        DatePairParer datePairParer = new DatePairParerImpl();
        datePairParer.parseDatePair("jj 02 1980, 03 04 1990");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseDatePairIllegal3(){
        DatePairParer datePairParer = new DatePairParerImpl();
        datePairParer.parseDatePair("33 02 1980, 03 04 1990");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseDatePairFirstGreaterThanSecond(){
        DatePairParer datePairParer = new DatePairParerImpl();
        datePairParer.parseDatePair("01 02 2000, 22 01 2000");
    }

    @Test
    public void testParseDatePairEqualDates(){
        DatePairParer datePairParer = new DatePairParerImpl();
        DatePair datePair = datePairParer.parseDatePair("01 02 2000, 01 02 2000");
        assertEquals("Year for first date should be 2000",2000,datePair.getFirstDate().getYear());
        assertEquals("month for first date should be 2",2,datePair.getFirstDate().getMonth());
        assertEquals("day for first date should be 1",1,datePair.getFirstDate().getDay());

        assertEquals("Year for second date should be 2000",2000,datePair.getSecondDate().getYear());
        assertEquals("month for second date should be 2",2,datePair.getSecondDate().getMonth());
        assertEquals("day for second date should be 1",1,datePair.getSecondDate().getDay());
    }

    @Test
    public void testParseDatePairUnequalDates(){
        DatePairParer datePairParer = new DatePairParerImpl();
        DatePair datePair = datePairParer.parseDatePair("02 03 1990, 04 05 2001");
        assertEquals("Year for first date should be 1990",1990,datePair.getFirstDate().getYear());
        assertEquals("month for first date should be 3",3,datePair.getFirstDate().getMonth());
        assertEquals("day for first date should be 2",2,datePair.getFirstDate().getDay());

        assertEquals("Year for second date should be 2001",2001,datePair.getSecondDate().getYear());
        assertEquals("month for second date should be 5",5,datePair.getSecondDate().getMonth());
        assertEquals("day for second date should be 4",4,datePair.getSecondDate().getDay());
    }

    @Test
    public void testGetDifferenceDays(){
        DatePair datePair = new DatePair(new MyDate(1990,1,1),
                new MyDate(1990,1,1));
        assertEquals("the difference days between 01-01-1990 and 01-01-1990 should be 0",
                0,datePair.getDifferenceDays());
    }

}