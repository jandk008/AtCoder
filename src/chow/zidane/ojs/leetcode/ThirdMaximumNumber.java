package chow.zidane.ojs.leetcode;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number.
 * The time complexity must be in O(n).
 */
class ThirdMaximumNumber {

    /**
     * Use 3 variables to store 3 the most biggest number met, adjust each one when meet up with a new number.
     * T(n) = O(n), S(n) = O(1). Beats 65% submission, good.
     */
    static class StoreTop3Max implements Executable {

        @Override
        public int execute(final int[] nums) {
            int max = Integer.MIN_VALUE, mid = max, min = max;
            for (int ele : nums) {
                if (ele > max) {
                    min = mid;
                    mid = max;
                    max = ele;
                } else if (max > ele && ele > mid) {
                    min = mid;
                    mid = ele;
                } else if (mid > ele && ele > min) {
                    min = ele;
                }
            }
            return (min != Integer.MIN_VALUE ? min : max);
        }
    }
}
