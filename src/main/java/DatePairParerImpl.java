import java.util.Objects;

/**
 * Created by YunZhang on 9/2/17.
 */
public class DatePairParerImpl implements DatePairParer {
    @SuppressWarnings("Since15")
    public DatePair parseDatePair(String str) {
        String val = Objects.requireNonNull(str);
        //DD MM YYYY, DD MM YYYY
        final String regex = "\\d\\d\\s+\\d\\d\\s+\\d\\d\\d\\d,\\s*\\d\\d\\s+\\d\\d\\s+\\d\\d\\d\\d";
        if (val.matches(regex)){
            String[] dateStrs = val.trim().split(",");
            MyDate firstDate = parseDate(dateStrs[0].trim());
            MyDate secondDate = parseDate(dateStrs[1].trim());
            if (firstDate.compareTo(secondDate) <= 0){
                return new DatePair(firstDate,secondDate);
            }else{
                throw new IllegalArgumentException("First date must less than second date");
            }
        }else{
            throw new IllegalArgumentException("The date pair str must match the pattern " +
                    "DD MM YYYY, DD MM YYYY");
        }
    }

    private MyDate parseDate(String dateStr) {
        //<code>dateStr has been validated</code>
        String strs[] = dateStr.split("\\s+");
        int day = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int year = Integer.parseInt(strs[2]);
        return new MyDate(year,month,day);
    }
}
