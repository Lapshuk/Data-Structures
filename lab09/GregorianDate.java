public class GregorianDate extends Date {

    public static int[] monthLengths = {31, 28, 31, 30, 31, 30, 31,
        31, 30, 31, 30, 31};

    public GregorianDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    @Override
    public int dayOfYear() {
        int rtnValue = 0;
        for (int m = 0; m < month() - 1; m++) {
            rtnValue += monthLengths[m];
        }
        return rtnValue + dayOfMonth();
    }

    public Date nextDate() {

        int tYear = year();
        int tMonth = month();
        int tDay = dayOfMonth();

        if (dayOfMonth() + 1 > monthLengths[month()-1] && month() < 12) {
            tMonth += 1;
            tDay = 1;
        } else if (dayOfMonth() + 1 > monthLengths[month()-1] && month() == 12) {
            tMonth = 1;
            tDay = 1;
            tYear += 1;
        } else {
            tDay += 1;
        }
        return new GregorianDate(tYear, tMonth, tDay);
    }

}
