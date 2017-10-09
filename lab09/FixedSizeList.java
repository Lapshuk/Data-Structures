public class FixedSizeList implements SimpleList {

    /**
     * List of elements.
     */
    protected int[] values;
    /**
     * Number of array cells used by the list.
     */
    int count = -1;


    /**
     * Initializes a FixedSizeList with specified capacity. The capacity is the
     * the actual size of the array (i.e. the max number of items it can hold).
     */
    public FixedSizeList(int capacity) {
        values = new int[capacity];
        count = 0;
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return count;
    }

    /**
     * Returns true if the list is empty, else false.
     */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds the int k to the list by placing it in the first unused spot in
     * values.
     */
    public void add(int k) {
        if (count + 1 > values.length) {
            throw new ListException("Unable to add element. Out of Bounds");
        } else {
            values[count] = k;
            count += 1;
        }

    }

    /**
     * Removes k from the list if it is present. If k appears multiple times,
     * it only removes the first occurence of k.
     */
    public void remove(int k) {
        for (int i = 0; i < count; i++) {
            if (values[i] == k) {
                for (int j = i; j < count-1; j++) {
                    values[j] = values[j + 1];
                }
                count--;
                break;
            }
        }
    }

    /**
     * Returns if the collection contains k.
     */
    public boolean contains(int k) {
        for (int i = 0; i < count; i++) {
            if (values[i] == k) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the integer stored at the i-th index in the list.
     */
    public int get(int i) {
        if (i >= values.length && i >= count) {
            throw new ListException("Cannot get item. Index out of bounds or item does not exist");
        }
        return values[i];
    }

    /**
     * Inserts k into the list at position i by shifting each element at index
     * i and onwards one entry to the right.
     * Precondition: i is between 0 and count, inclusive.
     */
    public void add(int i, int k) {
        if (i > count || count+1 == values.length ) {
            throw new ListException("Cannot add item at index. Out of bounds.");
        }

        for (int j = count; j >= i ; j--) {
            values[j + 1] = values[j];
        }
        values[i] = k;
        count++;
    }

    /**
     * Removes the entry at position i by shifting each element after position
     * i one entry to the left.
     */
    public void removeIndex(int i) {
        if (i >= count) {
            throw new ListException("Cannot remove item at index. Index does not exist");
        }
        for (int j = i; j < count; j++) {
            values[j] = values[j + 1];
        }
        count--;
    }

}
