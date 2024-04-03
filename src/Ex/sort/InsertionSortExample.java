package Ex.sort;
public class InsertionSortExample {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.print("After pass " + i + ": ");
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {20, 35, -15, 7, 55, 1, -22, 55, 2};
        int[] arr2 = {9, 6, 8, 12, 3, 1, 5, -4, 2};

        System.out.println("Original array 1: ");
        printArray(arr1);
        System.out.println("Insertion Sort process for array 1:");
        insertionSort(arr1);

        System.out.println();

        System.out.println("Original array 2: ");
        printArray(arr2);
        System.out.println("Insertion Sort process for array 2:");
        insertionSort(arr2);
    }
}
