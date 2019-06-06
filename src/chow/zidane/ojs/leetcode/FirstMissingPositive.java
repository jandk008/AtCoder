package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.util.CommonTool.swap;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
class FirstMissingPositive {

    /**
     * Address the range of numbers and mark the each valid number. (17ms)
     * Complexity of space is no t O(n). First a marked array is created with the bottom line be designated to be 0,  and maximum number
     * will be the top line. Then iterate each positive number of array to put it into the proper position. Finally iterate the marked
     * array , the first number which is not marked will be returned, otherwise the maximum number + 1 will be returned.
     * T(n) = O(n) with S(n), beating 9.6% java submission, not good.
     */
    static class MaximumRange {

        static Integer find(final int[] nums) {
            int min = 0;
            int max = min;
            for (int i : nums) {
                if (i > max) {
                    max = i;
                }
            }
            int[] records = new int[max - min + 1];
            int length = records.length;
            int bucketNum = min;
            for (int i = 0; i < length; i++) {
                records[i] = bucketNum++;
            }
            for (int i : nums) {
                if (i < 0) {
                    continue;
                }
                records[i - min] = 0;
            }
            for (int i : records) {
                if (records[i] != 0) {
                    return i;
                }
            }
            return length;
        }
    }

    /**
     * Swap each number to the appropriated position.(12ms)
     * A quite smart way to save the space and time in which we only focus on swapping the number to the correct position in the original
     * array, which can save space. The core steps are putting the 'n' to A[n-1]  where n is positive and keep trying to swap the swapped
     * number. Otherwise the swapped number won't be verified.
     * T(n) = O(n) with S(n) = (1), beats 70.73% java submission, performance good.
     */
    static class Swap {

        static Integer find(final int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }

            for (int i = 0; i < n; ++i) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            return n + 1;
        }
    }
}
