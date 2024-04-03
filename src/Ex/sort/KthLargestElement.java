package Ex.sort;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 5;
        System.out.println("Kth largest element is: " + findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int kthPosition = n - k;
        return quickSelect(nums, 0, n - 1, kthPosition);
    }

    private static int quickSelect(int[] nums, int low, int high, int k) {
        int pivotIndex = partition(nums, low, high);

        if (pivotIndex == k) {
            return nums[k];
        } else if (pivotIndex < k) {
            return quickSelect(nums,pivotIndex+1,high,k);
        } else {
            return quickSelect(nums,low,pivotIndex-1,k);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        // Implement here
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


/*public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 5;
        System.out.println("Kth largest element is: " + findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int kthPosition = n - k;
        return quickSelect(nums, 0, n - 1, kthPosition);
    }

    private static int quickSelect(int[] nums, int low, int high, int k) {
        int pivotIndex = partition(nums, low, high);

        if (pivotIndex == k) {
            return nums[k];
        } else if (pivotIndex < k) {
            return quickSelect(nums, pivotIndex + 1, high, k);
        } else {
            return quickSelect(nums, low, pivotIndex - 1, k);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}*/