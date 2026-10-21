import java.util.Arrays;
    public class insertionSort {

        // Insertion sort using do-while loops only (no for loops)
        public static void insertionSort(int[] arr) {
            int n = arr.length;
            if (n < 2) return;

            int i = 1;
            do {
                int key = arr[i];          // element to insert into the sorted part
                int j = i - 1;

                // shift larger elements one position to the right
                if (arr[j] > key) {
                    do {
                        arr[j + 1] = arr[j];
                        j--;
                    } while (j >= 0 && arr[j] > key);
                }
                arr[j + 1] = key;          // place key in its correct position

                i++;
            } while (i < n);
        }

        public static void main(String[] args) {
            int[] data = {64, 25, 12, 22, 11};

            System.out.println("Before sorting: " + Arrays.toString(data));
            insertionSort(data);

            System.out.println("After sorting:  " + Arrays.toString(data));
        }
    }
