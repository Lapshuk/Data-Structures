/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 * Encapsulated version.
 */
public class IntList {

    /**
     * The head of the list is the first node in the list. 
     * If the list is empty, head is null 
     */
    private IntListNode head;
    private int size;

    /**
     * IntListNode is a nested class. It can be instantiated
     * when associated with an instance of IntList.
     */
    public class IntListNode {
        int item;
        IntListNode next;

        public IntListNode(int item, IntListNode next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return "IntListNode{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IntListNode that = (IntListNode) o;

            if (item != that.item) return false;
            return next != null ? next.equals(that.next) : that.next == null;
        }

        @Override
        public int hashCode() {
            int result = item;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }

    public int getSize() {
        return size;
    }

    public IntList() {}

    public IntList(int[] initial) {
        for (int i = initial.length - 1; i >= 0; i--) {
            head = new IntListNode(initial[i], head);
        }
        size = initial.length;
    }

    /**
     * Get the value at position pos. If the position does not exist, throw an
     * IndexOutOfBoundsException.
     * @param position to get from
     * @return the int at the position in the list.
     */
    public int get(int position) {
        if (position >= size) throw new IndexOutOfBoundsException("Position larger than size of list.");
        IntListNode curr = head;
        while (position > 0) {
            curr = curr.next;
            position--;
        }
        return curr.item;
    }

    /* Fill in below! */

    /**
     * Insert a new node into the IntList.
     * @param x value to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *            the end of the list.
     */
    public void insert(int x, int position) {
        if (head == null || position == 0){
            IntListNode temp = head;
            head = new IntListNode(x, temp);
        } else {
            IntListNode p = head;
            for (int i = 1; i < position; i++, p = p.next) {
                if (p.next == null) {
                    p.next = new IntListNode(x, null);
                    size++;
                    return;
                }
            }
            IntListNode temp = p.next;
            p.next = new IntListNode(x, temp);
        }
        size++;
    }

    /**
     * Merge two sorted IntLists a and b into one sorted IntList containing all of their elements.
     * @return a new IntList without modifying either parameter
     */
    public static IntList merge(IntList a, IntList b) {
        IntList merged = new IntList();
        IntList aPos = a;
        IntList bPos = b;
        for (int i=0; i < a.size + b.size; i++) {

            if(aPos.head == null || (( bPos.head != null) && bPos.head.item < aPos.head.item)) {
                merged.insert(bPos.head.item, i);
                bPos.head = bPos.head.next;
            } else{
                merged.insert(aPos.head.item, i);
                aPos.head = aPos.head.next;
            }
        }
        return merged;
    }

    /**
     * Reverse the current list recursively, using a helper method.
     */
    public void reverse() {
        head = reverseHelper(head, null);
    }

    private static IntListNode reverseHelper(IntListNode l, IntListNode soFar) {
        if (l == null) {
            return soFar;
        } else {
            IntListNode temp = l.next;
            l.next = soFar;
            return reverseHelper(temp, l);
        }
    }

    /* Optional! */

    /**
     * Remove the node at position from this list.
     * @param position int representing the index of the node to remove. If greater than the size
     *                 of this list, throw an IndexOutOfBoundsException.
     */
    public void remove(int position) {
//        if (position >= size) throw new IndexOutOfBoundsException();
//        IntList prev = null;
//        IntList aPos = a;
//        for(int i=0; i <= position; i++) {
//            prev = this.;
//        }
    }

    @Override
    public String toString() {
        return "IntList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntList intList = (IntList) o;

        if (size != intList.size) return false;
        return head != null ? head.equals(intList.head) : intList.head == null;
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }
}
