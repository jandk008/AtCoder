package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.util.CommonTool.swap;

class QuickSorting {

    static int[] sort(final int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int partition = partition(nums, l, r);
        quickSort(nums, l, partition - 1);
        quickSort(nums, partition + 1, r);
    }

    private static int partition(final int[] nums, int l, int r) {
        int pivotIndex = l;
        while (l < r) {
            while (l <= r && nums[l] <= nums[pivotIndex]) {
                l++;
            }
            while (l <= r && nums[r] > nums[pivotIndex]) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        swap(nums, pivotIndex, r);
        return r;
    }
}
