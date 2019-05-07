package chow.zidane.ojs.leetcode;

public class FindKthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestFromScope(nums, 0, nums.length - 1, k);
    }

    private int findKthLargestFromScope(int[] nums, int i, int j, int k) {
        int pivotIndex = i;
        int end = j;
        while (i < j) {
            while (i <= j && nums[i] <= nums[pivotIndex]) {
                i++;
            }
            while(j >= i && nums[j] > nums[pivotIndex]) {
                j--;
            }
            if (i < j) swap(nums, i, j);
        }
        swap(nums, pivotIndex, j);
        int largest = end - j + 1;
        if (largest == k) {
            return nums[j];
        } else if (largest > k) {
            return findKthLargestFromScope(nums, j + 1, end, k);
        } else {
            return findKthLargestFromScope(nums, pivotIndex, j - 1, k - largest);
        }
    }

    private void swap(int[] a, int leftPosition, int rightPosition) {
        int temp = a[leftPosition];
        a[leftPosition] = a[rightPosition];
        a[rightPosition] = temp;
    }

    public static void main(String[] args) {
        FindKthLargestInArray findKthLargestInArray = new FindKthLargestInArray();
        int[] nums = {5, 7, 8, 9, 23, 45, 12, 99, 5};
        int k = 7;
        System.out.println(findKthLargestInArray.findKthLargest(nums, k));
    }
}
