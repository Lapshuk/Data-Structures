public class Time {

    private int myHours;
    private int myMinutes;
    
    public Time (String s) throws  IllegalArgumentException{
        try {
            int colonPos = s.indexOf(":");
            String hours, minutes;

            if (colonPos < 0) {
                throw new IllegalArgumentException("Missing colon in a time string");
            } else {
                hours = s.substring(0, colonPos);
                minutes = s.substring(colonPos + 1);
            }

            if (s.indexOf(" ") >= 0) {
                throw new IllegalArgumentException("Space encountered in provided time string");
            } else if (hours.length() > 2
                    || minutes.length() > 2){
                throw new IllegalArgumentException("Too many leading zeroes in the hours or minutes");
            } else if (hours.length() == 0
                    || minutes.length() == 0){
                throw new IllegalArgumentException("Hours or minutes are missing");
            } else if (!minutes.substring(0,1).equals("0")){
                throw new IllegalArgumentException("Minutes must start with 0 for min < 10");
            }


            myHours = Integer.parseInt(s.substring(0, colonPos));
            myMinutes = Integer.parseInt(s.substring(colonPos + 1));

            if (myHours > 23 || myMinutes > 59) {
                throw new IllegalArgumentException("Hours or minutes are out of range");
            }


        } catch (NumberFormatException a){
            throw new IllegalArgumentException("Need int but no ints given in a string");
        } catch (NullPointerException b) {
            throw new IllegalArgumentException("Time string is null");
        }
    }
    
    public Time (int hours, int minutes) throws IllegalArgumentException {

            if (hours > 23 || minutes > 59){

                throw new IllegalArgumentException("values for hours and minutes that are out of range.");
            }
            myHours = hours;
            myMinutes = minutes;

    }

    public boolean equals (Object obj) {
        Time t = (Time) obj;
        return myHours == t.myHours && myMinutes == t.myMinutes;
    }

    public String toString() {
        if (myMinutes < 10) {
            return myHours + ":0" + myMinutes;
        } else {
            return myHours + ":" + myMinutes;
        }
    }
}
