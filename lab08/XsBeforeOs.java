public class XsBeforeOs {

    // Rearrange the elements of values so that all the Xs precede all
    // the Os.
    public static void rearrange(char[] values) {
        int lastXpos = -1;
        for (int k = 0; k < values.length; k++) {
            if (values[k] == 'X') {

                values[lastXpos+1] = 'X';
                values[k] = 'O';

            }
            try {
                isOK(values, k);
            } catch (IllegalStateException e) {
                System.err.println("inconsistency at position " + k);
            }
        }
    }

    // Check for consistency. All the Xs in elements 0 to k of values should
    // precede all the Os. Throw an IllegalStateException if this is not
    // consistent.
    public static void isOK (char[] values, int k) {
        boolean seenO = false;
        for(int i = 0; i <= k; i++){
            if (values[i] == 'O') {
                seenO = true;
            } else if (values[i] == 'X' && seenO) {
                String message = "There is an O proceeding an X at index "+ i;
                throw new IllegalStateException(message);
            }
        }

    }
}
