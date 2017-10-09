public class InsertionSort {
    
    // Precondition: elements 0 through k-1 of list are in increasing order.
    // Postcondition: elements 0 through k of list are in increasing order.
    public static void insert(int list[], int k) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = k; i < list.length; i++) {
            if (list[i] < min) {
                min = list[i];
                minIndex = i;
            }
        }
        int originalFirstElement = list[k];
        list[k] = list[minIndex];
        list[minIndex] = originalFirstElement;
    }
    
    // Does nothing when elements 0 through k of list are sorted in
    // increasing order.
    // Throws an IllegalStateException otherwise.
    public static void isOK (int[] list, int k) {

        if(k >= list.length || k < 0){
            throw new IllegalArgumentException("invalid k");
        }

        int prev = list[0];
        for(int i = 1; i < k ; i++){
            if (list[i] < prev){
                throw new IllegalStateException("list not sorted");
            } else {
                prev = list[i];
            }
        }

    }

    public static int[] insertionSort(int[] list) {
        int[] rtn = new int[list.length];
        for (int k = 0; k < list.length; k++) {
            rtn[k] = list[k];
        }
        for (int k = 0; k < rtn.length; k++) {
            insert(rtn, k);
            try {
                isOK(rtn, k);
            } catch (IllegalStateException e) {
                System.err.println("inconsistency at position " + k);
            }
        }
        return rtn;
    }
    
    public static void main (String[] args) {
        int[] list = {3, 1, 7, 4, 5, 9, 2, 8, 6};
        list = insertionSort(list);
        for (int k = 0; k < list.length; k++) {
            System.out.print(list[k]);
        }
        System.out.println();
    }

}
