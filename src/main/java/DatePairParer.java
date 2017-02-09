/**
 * Created by YunZhang on 9/2/17.
 */
public interface DatePairParer {
    /**
     * parse <code>str</code> as <code>DatePair<code/> objects.
     * Use interface to accommodate different date pair str formates
     * @param str
     * @return
     */
    DatePair parseDatePair(String str);
}
