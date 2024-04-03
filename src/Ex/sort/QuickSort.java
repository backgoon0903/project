package Ex.sort;



public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println("Pivot: " + arr[pi] + " at index  " + (pi) + ": ");
            printArray(arr, low, high);
            System.out.println("----");

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
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;


        return i + 1;
    }

    private static void printArray(int[] arr, int low, int high) {
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {10, 7, 8, 9, 1, 5, 3, 6};
        System.out.print("Original array:");
        printArray(arr,0,arr.length-1);
        quickSort(arr,0,arr.length-1);
        System.out.print("Sorted array:");
        printArray(arr,0,arr.length-1);

    }
}

/*Original array:
10 7 8 9 1 5 3 6
Sorting process:
Pivot: 6 at index 3
1 5 3 6 10 7 8 9
----
Pivot: 3 at index 1
1 3 5
----
Pivot: 9 at index 6
7 8 9 10
----
Pivot: 8 at index 5
7 8
----
Sorted array:
1 3 5 6 7 8 9 10*/
