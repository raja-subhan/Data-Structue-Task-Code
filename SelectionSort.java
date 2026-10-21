import java.util.Arrays;
public class selectionSort {

    // Selection sort using do-while loops only (no for loops)
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;

        int i = 0;
        do {
            int minIndex = i;          // assume current position holds the minimum
            int j = i + 1;

            do {                       // find the smallest element in the unsorted part
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                j++;
            } while (j < n);

            // swap the smallest element into position i
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            i++;
        } while (i < n - 1);
    }

    public static void main(String[] args) {
        int[] data = {64, 25, 12, 22, 11};


        System.out.println("Before sorting: " + Arrays.toString(data));
        selectionSort(data);
        System.out.println("After sorting:  " + Arrays.toString(data));
    }
}
