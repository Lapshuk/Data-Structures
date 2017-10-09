public class DLList {
    DLNode sentinel;
    int size;

    public class DLNode {
        Object item;
        DLNode prev, next;

        public DLNode(Object item, DLNode prev, DLNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DLNode dlNode = (DLNode) o;

            if (item != null ? !item.equals(dlNode.item) : dlNode.item != null) return false;
            if (prev != null ? !prev.equals(dlNode.prev) : dlNode.prev != null) return false;
            return next != null ? next.equals(dlNode.next) : dlNode.next == null;
        }

    }

    /**
     * Construct a new DLList with a sentinel that points to itself.
     */
    public DLList() {
        sentinel = new DLNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Insert into the end of this list
     *
     * @param o Object to insert
     */
    public void insertBack(Object o) {
        DLNode n = new DLNode(o, sentinel.prev, sentinel);
        n.next.prev = n;
        n.prev.next = n;
        size++;
    }


    /**
     * Get the value at position pos. If the position does not exist, return null (the item of
     * the sentinel).
     *
     * @param position to get from
     * @return the Object at the position in the list.
     */
    public Object get(int position) {
        DLNode curr = sentinel.next;
        while (position > 0 && curr != sentinel) {
            curr = curr.next;
            position--;
        }
        return curr.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("DLList(");
        DLNode curr = sentinel.next;
        while (curr != sentinel) {
            s.append(curr.item.toString());
            if (curr.next != sentinel) s.append(", ");
            curr = curr.next;
        }
        s.append(')');
        return s.toString();
    }

    /* Fill these in! */

    /**
     * Insert a new node into the DLList.
     *
     * @param o        Object to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *                 the end of the list.
     */
    public void insert(Object o, int position) {

        if (position > size) {
            insertBack(o);
            return;

        } else if (position == 0) {
            DLNode temp1 = new DLNode(o, sentinel, sentinel.next);
            sentinel.next.prev = temp1;
            sentinel.next = temp1;

        } else {
            DLNode temp = sentinel.next;
            for (int i = 1; i < position; i++) {
                temp = temp.next;
            }

            DLNode n1 = new DLNode(o, temp, temp.next);
            temp.next.prev = n1;
            temp.next = n1;
        }
        size++;
    }

    /**
     * Insert into the front of this list. You should can do this with a single call to insert().
     *
     * @param o Object to insert
     */
    public void insertFront(Object o) {
        insert(o, 0);
    }

    /**
     * Remove all copies of Object o in this list
     *
     * @param o Object to remove
     */
    public void remove(Object o) {
        DLNode curr = sentinel.next;
        while (curr != sentinel) {
            if (curr.item.equals(o)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                size--;
            }
            curr = curr.next;
        }
    }

    /**
     * Remove a DLNode from this list. Does not error-check to make sure that the node actually
     * belongs to this list.
     *
     * @param n DLNode to remove
     */
    public void remove(DLNode n) {
        DLNode curr = sentinel.next;
        while (curr != sentinel) {
            if (curr.equals(n)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                size--;
            }
            curr = curr.next;
        }
    }


    /**
     * Duplicate each node in this linked list destructively.
     */
    public void doubleInPlace() {
        DLNode curr = sentinel.next;
        while (curr != sentinel){
            DLNode copy = new DLNode(curr.item, curr.prev, curr);
            curr.prev.next = copy;
            curr.prev = copy;
            curr = curr.next;
            size++;
        }
    }

    /**
     * Reverse the order of this list destructively.
     */
    public void reverse() {
        DLNode curr = sentinel.next;
        DLNode head = curr;

        while(curr != sentinel){
            DLNode temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        sentinel.next = sentinel.prev;
        sentinel.prev = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DLList dlList = (DLList) o;

        if (size != dlList.size) return false;
        return sentinel != null ? sentinel.equals(dlList.sentinel) : dlList.sentinel == null;
    }

//    @Override
//    public int hashCode() {
//        int result = sentinel != null ? sentinel.hashCode() : 0;
//        result = 31 * result + size;
//        return result;
//    }

    public static void main(String[] args) {
        // you can add some quick tests here if you would like
    }
}
