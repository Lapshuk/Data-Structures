/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * @author Maurice Lee and Wan Fung Chui
 */

public class IntList {

    /** The integer stored by this node. */
    private int item;
    /** The next node in this IntList. */
    private IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints (1 2 3) */
    public static IntList list(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /** Returns the integer stored by this IntList. */
    public int item() {
        return item;
    }

    /** Returns the next node stored by this IntList. */
    public IntList next() {
        return next;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("The position is out of range");
        }
        IntList curr = this;
        for (int i = 0; i < position; i++){
            if (curr.next == null){
                throw new IllegalArgumentException("The position is out of range");
            }
            curr = curr.next;
        }
        return curr.item;
    }

    /**
     * Returns the size of the list.
     *
     * @return The size of the list.
     */
    public int size() {
        IntList curr = this;
        int size = 0;
        for(; curr != null; size++){
            curr = curr.next();
        }
        return size;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "( 1 2 3 )".
     *
     * @return The String representation of the list.
     */
    public String toString() {

        IntList curr = this;
        String s = "( ";
        while (curr != null){
            s += curr.item + " ";
            curr = curr.next;
        }
        
        return s + ")";
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if(!(obj instanceof IntList)) { return false; }
        IntList curr = this;
        while(curr != null){
            if(obj == null) { return false; }
            if(curr.item != ((IntList) obj).item){
                return false;
            } else {
                curr = curr.next;
                obj = ((IntList) obj).next;
            }
        }
        return true;


    }

    /**
     * Adds the given item at the end of the list.
     *
     * @param item, the int to be added.
     */
    public void add(int item) {
        IntList curr = this;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new IntList(item);
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        IntList curr = this;
        int smallest = curr.item;
        while(curr != null){
            if(smallest > curr.item){
                smallest = curr.item;
            }
            curr = curr.next;
        }
        return smallest;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {

        IntList curr = this;
        int x = 0;
        while (curr != null){
            x += curr.item*curr.item;
            curr = curr.next;
        }
        return x;
    }

    /**
     * Returns a new IntList consisting of L1 followed by L2,
     * non-destructively.
     *
     * @param l1 list to be on the front of the new list.
     * @param l2 list to be on the back of the new list.
     * @return new list with L1 followed by L2.
     */
    public static IntList append(IntList l1, IntList l2) {
        IntList newList;

        if(l1 != null){
            newList = new IntList(l1.get(0));
            for(int i = 1; i < l1.size(); i++){
                newList.add(l1.get(i));
            }
            if(l2 != null) {
                for(int i = 0; i < l2.size(); i++){
                    newList.add(l2.get(i));
                }
            }
        }
        else if(l2 != null) {
            newList = new IntList(l2.get(0));
            for(int i = 1; i < l2.size(); i++){
                newList.add(l2.get(i));
            }
        }
        else { return null; }

        return newList;
    }
}