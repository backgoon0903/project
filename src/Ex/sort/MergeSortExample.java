package Ex.sort;

public class MergeSortExample {

    public static void main(String[] args) {
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10, -1, 5, 22};
        int[] arr2 = {38, 27, 43, 3, 9, 82, 10, -1, 5, 22, 55};

        System.out.println("Original array 1: ");
        printArray(arr1);
        System.out.println("Sorting process:");
        mergeSort(arr1, 0, arr1.length - 1);
        System.out.println("Sorted array 1: ");
        printArray(arr1);

        System.out.println("\nOriginal array 2: ");
        printArray(arr2);
        System.out.println("Sorting process:");
        mergeSort(arr2, 0, arr2.length - 1);
        System.out.println("Sorted array 2: ");
        printArray(arr2);
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            System.out.println("Dividing: " + getSubArray(arr, left, right));

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        System.out.println("Merging: " + getSubArray(arr, left, right));
    }

    public static String getSubArray(int[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]);
            if (i < end) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}