package chow.zidane.ojs.leetcode;

class SearchInRotatedSortedArray {

    static int search(final int[] nums, final int target) {
        if (nums.length == 0) return -1;
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int i, int j, int target) {
        if (i > j) return -1;
        int mid = i + (j - i) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target && nums[j] >= target) return binarySearch(nums, mid + 1, j, target);
        else if (nums[mid] > target && nums[i] <= target) return binarySearch(nums, i, mid - 1, target);
        else if (nums[mid] < nums[i]) return binarySearch(nums, i, mid - 1, target);
        else return binarySearch(nums, mid + 1, j, target);
    }
}
