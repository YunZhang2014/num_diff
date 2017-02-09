/**
 *
 * Created by Yun Zhang on 9/2/17.
 */
public class DatePair {

    private MyDate firstDate;

    private MyDate secondDate;

    public DatePair(MyDate firstDate, MyDate secondDate) {
        this.firstDate = firstDate;
        this.secondDate = secondDate;
    }

    public MyDate getFirstDate() {
        return firstDate;
    }

    public MyDate getSecondDate() {
        return secondDate;
    }

    /**
     * get the difference days between first date and second date
     * @return
     */
    public int getDifferenceDays(){
        return secondDate.elapsedDays() - firstDate.elapsedDays();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d",firstDate,secondDate,getDifferenceDays());
    }
}
