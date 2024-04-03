package Ex.sort;

public class SortComparison {

    public static void bubbleSort(int[] arr) {
        // Implement Bubble Sort here
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }for (int z : arr) {
                System.out.print(z + " ");
            }System.out.println();
        }

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println("Pivot: " + arr[pi] + " at index  " + (pi) + ": ");
            printArray(arr);
            System.out.println("----");

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        // Implement Quick Sort Here
        // Use partition method below
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void printArray(int[] arr) {
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        int[] arr2 = arr1.clone();

        long startTime = System.nanoTime();
        bubbleSort(arr1);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " ns");
        printArray(arr1);

        startTime = System.nanoTime();
        quickSort(arr2, 0, arr2.length-1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endTime - startTime) + " ns");
        printArray(arr2);
    }
}