package Ex.search;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchExample {
    public static List<Integer> findAllIndices(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 3, 9, 3, 2, 3};
        int target = 3;
        List<Integer> indices = findAllIndices(arr, target);

        System.out.println("Indices of target " + target + ": " + indices);
    }
}