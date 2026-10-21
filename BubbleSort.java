import java.util.Arrays;
public class BubbleSort {

    // Bubble sort using do-while loops only (no for loops)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;

        int pass = 0;
        do {
            boolean swapped = false;
            int j = 0;

            do {                               // compare neighbours in the unsorted part
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                j++;
            } while (j < n - 1 - pass);

            if (!swapped) {                    // already sorted, stop early
                break;
            }
            pass++;
        } while (pass < n - 1);
    }

    public static void main(String[] args) {

        int[] data = {64, 25, 12, 22, 11};

        System.out.println("Before sorting: " + Arrays.toString(data));
        bubbleSort(data);
        System.out.println("After sorting:  " + Arrays.toString(data));
    }
}
