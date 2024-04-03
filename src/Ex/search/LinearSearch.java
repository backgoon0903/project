package Ex.search;


public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // 대상 값과 일치하는 요소의 인덱스 반환
            }
        }
        return -1; // 대상 값이 배열에 없으면 -1 반환
    }

    public static void main(String[] args) {
        int[] arr = {3, 45, 1, 2, 8};
        int target = 2;
        int result = linearSearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}