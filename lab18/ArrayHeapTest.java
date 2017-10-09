import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by stephanieclaudinodaffara on 7/27/17.
 */
public class ArrayHeapTest {

    @Test
    public void testWorsenPriority() {
        ArrayHeap<String> a = new ArrayHeap<>();
        a.insert("a", 1);
        a.insert("b", 20);
        a.insert("c", 3);
        a.insert("d", 6);
        a.insert("e", 10);
        System.out.println(a);
        a.changePriority("e", 7);
        System.out.println(a);
    }

    @Test
    public void testBetterPriority() {
        ArrayHeap<String> a = new ArrayHeap<>();
        a.insert("a", 1);
        a.insert("b", 5);
        a.insert("c", 3);
        a.insert("d", 6);
        a.insert("e", 7);
        System.out.println(a);
        a.changePriority("d", 0);
        System.out.println(a);
    }

    @Test
    public void testSorted() {
        ArrayHeap<String> a = new ArrayHeap<>();
        a.insert("a", 1);
        a.insert("h", 10);
        a.insert("b", 5);
        a.insert("c", 3);
        a.insert("e", 7);
        a.insert("f", 8);
        a.insert("d", 6);
        a.insert("g", 9);
        System.out.println(a);

        while (!a.isEmpty()) {
            System.out.println(a.removeMin());
//            System.out.println(a);
        }


    }


}