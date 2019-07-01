package chow.zidane.ojs.leetcode;

class MinimumInRotatedSortedArray {

    static int find(final int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < nums[j]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }

        return nums[i];
    }

}
