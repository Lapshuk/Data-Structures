public class FrenchRevolutionaryDate extends Date {

    /** In a nonleap year for the French Revolutionary Calendar, the first
     *  twelve months have 30 days and month 13 has five days.
     */
    public FrenchRevolutionaryDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    @Override
    public int dayOfYear() {
        return (month() - 1) * 30 + dayOfMonth();
    }

    public Date nextDate(){
        int tYear = year();
        int tMonth = month();
        int tDay = dayOfMonth();

        if (dayOfMonth() + 1 > 30 && month() < 13){
                tMonth += 1;
                tDay = 1;
        } else if (dayOfMonth() + 1 > 5 && month() == 13){
            tMonth = 1;
            tDay = 1;
            tYear = year() + 1;
        } else {
            tDay += 1;
        }

        return new FrenchRevolutionaryDate(tYear,tMonth,tDay);
    }



}
