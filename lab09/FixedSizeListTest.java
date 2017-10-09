import static org.junit.Assert.*;

/**
 * Created by stephanieclaudinodaffara on 7/6/17.
 */
public class FixedSizeListTest {

    @org.junit.Test
    public void TestConstructor() throws Exception {
        FixedSizeList a = new FixedSizeList(2);
        assertTrue(a.values[0] == 0);
        assertTrue(a.values[1] == 0);
        assertTrue(a.count == 0);
    }

    @org.junit.Test
    public void TestSize() throws Exception {
        FixedSizeList a = new FixedSizeList(2);
        assertTrue(a.size() == 0);
    }

    @org.junit.Test
    public void TestisEmpty() throws Exception {
        FixedSizeList a = new FixedSizeList(2);
        assertTrue(a.isEmpty() == true);

    }

    @org.junit.Test
    public void TestAdd() throws Exception {
        FixedSizeList a = new FixedSizeList(2);
        a.add(1);
        assertTrue(a.values[0] == 1);
        a.add(2);
        try {
            a.add(3);
            assertFalse(true);
        } catch(ListException e) {
            assertTrue(true);
        }
    }

    @org.junit.Test
    public void TestRemove() throws Exception {
        FixedSizeList a = new FixedSizeList(3);
        a.add(1);
        a.add(2);
        a.add(3);
        assertTrue(a.count == 3);
        assertTrue(a.values[0] == 1);
        a.remove(1);
        assertTrue(a.count == 2);
        assertTrue(a.values[0] == 2);
        assertTrue(a.values[1] == 3);
    }

    @org.junit.Test
    public void TestContains() throws Exception {
        FixedSizeList a = new FixedSizeList(3);
        a.add(1);
        a.add(2);
        assertTrue(a.values[1] == 2);
        assertTrue(a.contains(2));
        assertTrue(a.contains(1));
    }

    @org.junit.Test
    public void TestGet() throws Exception {
        FixedSizeList a = new FixedSizeList(3);
        a.add(1);
        a.add(2);
        assertTrue(a.values[1] == 2);
        assertTrue(a.get(1) == 2);
        try {
            a.get(3);
            assertFalse(true);
        } catch(ListException e) {
            assertTrue(true);
        }
    }

    @org.junit.Test
    public void TestAdd1() throws Exception {
        FixedSizeList a = new FixedSizeList(3);
        a.add(1);
        a.add(3);
        try {
            a.add(1, 2);
            assertFalse(true);
        } catch(ListException e) {
            assertTrue(true);
        }
    }

    @org.junit.Test
    public void TestRemoveIndex() {
        FixedSizeList a = new FixedSizeList(2);
        try {
            a.removeIndex(2);
            assertFalse(true);
        } catch(ListException e) {
            assertTrue(true);
        }
    }

}