import java.util.Arrays;

public class MergeSort {

    // Recursively split the array, then merge the sorted halves
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);        // sort left half
            mergeSort(arr, mid + 1, right);   // sort right half
            merge(arr, left, mid, right);     // merge the two sorted halves
        }
    }

    // Merge arr[left..mid] and arr[mid+1..right] using do-while loops only
    // (both halves always contain at least one element here, so do-while is safe)
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // copy data into temporary arrays
        int i = 0;
        do {
            L[i] = arr[left + i];
            i++;
        } while (i < n1);

        int j = 0;
        do {
            R[j] = arr[mid + 1 + j];
            j++;
        } while (j < n2);

        // merge the temporary arrays back into arr
        i = 0;
        j = 0;
        int k = left;
        do {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        } while (i < n1 && j < n2);

        // copy any remaining elements of L
        if (i < n1) {
            do {
                arr[k] = L[i];
                i++;
                k++;
            } while (i < n1);
        }

        // copy any remaining elements of R
        if (j < n2) {
            do {
                arr[k] = R[j];
                j++;
                k++;
            } while (j < n2);
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 25, 12, 22, 11, 90, 5};

        System.out.println("Before sorting: " + Arrays.toString(data));
        mergeSort(data, 0, data.length - 1);
        System.out.println("After sorting:  " + Arrays.toString(data));
    }
}
