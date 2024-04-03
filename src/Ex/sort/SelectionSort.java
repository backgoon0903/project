package Ex.sort;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            // Print the current state of the array
            System.out.println("After pass " + (i + 1) + ": ");
            printArray(arr);
        }
    }
    public static void printArray(int[] arr){
        for (int data: arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
       int[] arr1 = {29, 72, 98, 13, 87, 66, 52, 51, 36};
       int[] arr2 = {5, 3, 8, 4, 2, 9, 6, 1, 7 };
       System.out.println("Original array1: ");
       printArray(arr1);
       System.out.println();
       System.out.println("Selection Sort process for array 1:");
       selectionSort(arr1);
       System.out.println();
       System.out.println("Original array2: ");
       printArray(arr2);
       System.out.println();
       System.out.println("Selection Sort process for array 2:");
       selectionSort(arr2);
    }
}

