package Ex.sort;


public class HeapSortExample {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 1, 2, 3};
        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);

        int[] arr2 = {59, 13, 84, 27, 54, 9, 11, 39, 90, 72};
        System.out.println("Original array:");
        printArray(arr2);

        heapSort(arr2);
        System.out.println("Sorted array:");
        printArray(arr2);
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        System.out.println("Heap constructed:");
        printArray(arr);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);

            System.out.println("After removing the element at index " + i + ":");
            printArray(arr);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * 1 + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, n, i);
            heapify(arr, n, largest);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
