import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

@RunWith(JUnit4.class)
public class InsertionSortTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void isOK1() {
        int[] arr = {1, 5, 4, 6, 8};

        // This isOK call should return nothing because the array is sorted
        // up through the element at index 1.
        InsertionSort.isOK(arr, 1);

        // This isOK call should throw an exception because the element 4
        // makes the array up through the element at index 3 out of order.
        exception.expect(IllegalStateException.class);
        InsertionSort.isOK(arr, 3);
    }

    @Test
    public void isOK2() {

        int[] arr = {-1, 0, 0, 6, 8};
        InsertionSort.isOK(arr, 4);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("invalid k");
        InsertionSort.isOK(arr, 5);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("invalid k");
        InsertionSort.isOK(arr, -1);

    }

    @Test
    public void insert1() {
        int[] arr = {4, 5, 6, 2, 3, 9, 1, 7, 8, 0};

        for (int i = 0; i < arr.length; i++) {
            InsertionSort.insert(arr, i);
        }
    }

    @Test
    public void insert2() {

        int[] arr = new int[4];
        arr[0] = 3;
        arr[1] = 2;
        arr[2] = 4;
        arr[3] = 1;
        InsertionSort.insert(arr, 3);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    @Test
    public void insertionSort1() {
        int[] arr = {4, 5, 6, 2, 3, 9, 1, 7, 8, 0};
        int[] result = InsertionSort.insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(result[i]);
        }
        int[] check = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertEquals(Arrays.toString(result), Arrays.toString(check));
    }

    @Test
    public void insertionSort2() {

        // YOUR CODE HERE

    }

}
