package Ex.sort;

public class ShellSortExample {

    public static void shellSort(int[] arr) {
        int n = arr.length;

        // gap을 줄여가며 반복
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // gap만큼 떨어진 요소들에 대해 삽입 정렬 수행
            for (int i = gap; i < n; i += 1) {
                // 선택된 요소를 temp에 저장하고, 이전 요소들과 비교
                int temp = arr[i];

                // 선택된 요소보다 큰 요소들을 gap만큼 오른쪽으로 이동
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // 최종 위치에 선택된 요소를 삽입
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3, 1, 6, 78, 5, 11, 8};

        System.out.println("Original array:");
        printArray(arr);

        shellSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}