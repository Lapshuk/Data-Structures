/**
 * Created by stephanieclaudinodaffara on 7/6/17.
 */
public class ResizableList extends FixedSizeList {

    /** Initializes a ResizableList to the default size 10.
     */
    public ResizableList() {
        super(10);
    }

    /** Calls super method and resizes array if needed
     */
    public void add(int k) {
        try {
            super.add(k);
        } catch (ListException e) {
            values = resize();
            super.add(k);
        }
    }

    /** Calls super method and resizes array if needed
     */
    public void add(int i, int k) {
        try {
            super.add(i, k);
        } catch (ListException e) {
            values = resize();
            super.add(i, k);
        }
    }

    /** Resize the current values array to twice as big
     *  and return the new values array
     */
    public int[] resize() {
        int[] newValues = new int[values.length*2];
        for(int i = 0; i < values.length; i++){
            newValues[i] = values[i];
        }
        return newValues;
    }

}
