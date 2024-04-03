package Ex.sort;

public class SortComparison1 {

    public static void main(String[] args) {
        int[] array1 = generateRandomArray(10000);
        int[] array2 = array1.clone();

        long startTime = System.currentTimeMillis();
        bubbleSort(array1);
        long endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort Execution Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        quickSort(array2, 0, array2.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Quick Sort Execution Time: " + (endTime - startTime) + " ms");
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}